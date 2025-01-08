package cn.whlit.spring;

import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.messaging.ChangeStreamRequest;
import org.springframework.data.mongodb.core.messaging.Message;
import org.springframework.data.mongodb.core.messaging.MessageListener;
import org.springframework.data.mongodb.core.messaging.MessageListenerContainer;

import javax.annotation.PostConstruct;

/**
 * @author WangHaiLong 2024/12/24 10:34
 */
public abstract class MongoMessageListener<T> implements MessageListener<ChangeStreamDocument<Document>, T> {

    @Autowired
    private MessageListenerContainer container;

    @PostConstruct
    public void init() {
        if (!container.isRunning()) {
            container.start();
        }
        container.register(getRequest(), getType());
    }

    @Override
    public void onMessage(Message<ChangeStreamDocument<Document>, T> message) {
        ChangeStreamDocument<Document> raw = message.getRaw();
        if (raw == null) {
            return;
        }
        switch (raw.getOperationType()) {
            case INSERT -> insert(message.getBody());
            case UPDATE -> update(message.getBody());
            case REPLACE -> replaceDocument(message, raw);
            case DELETE -> deleteDocument(raw);
        }
    }

    private void deleteDocument(ChangeStreamDocument<Document> raw) {
        if (raw.getDocumentKey() != null) {
            delete(raw.getDocumentKey().getObjectId("_id").toString());
        }
    }

    private void replaceDocument(Message<ChangeStreamDocument<Document>, T> message, ChangeStreamDocument<Document> raw) {
        if (raw.getDocumentKey() != null) {
            delete(raw.getDocumentKey().getObjectId("_id").toString());
            insert(message.getBody());
        }
    }

    public abstract Class<T> getType();

    public abstract ChangeStreamRequest<T> getRequest();

    public abstract void insert(T document);

    public abstract void update(T document);

    public abstract void delete(String id);

}
