package cn.whlit.spring;

import cn.whlit.spring.domain.Geo;
import com.mongodb.client.model.changestream.FullDocument;
import com.mongodb.client.model.changestream.OperationType;
import org.springframework.data.mongodb.core.messaging.ChangeStreamRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author WangHaiLong 2024/12/26 16:13
 */
@Component
public class GeoMongoMessageListener extends MongoMessageListener<Geo> {

    @Override
    public Class<Geo> getType() {
        return Geo.class;
    }

    @Override
    public ChangeStreamRequest<Geo> getRequest() {

        return ChangeStreamRequest.builder(this)
                .collection("geo")
                .filter(newAggregation(match(new Criteria().orOperator(
                        where("operationType").in(OperationType.UPDATE, OperationType.INSERT, OperationType.REPLACE)
                                .and("fullDocument.type").is(0),
                        where("operationType").is(OperationType.DELETE)
                ))))
                .fullDocumentLookup(FullDocument.UPDATE_LOOKUP)
                .build();
    }

    @Override
    public void insert(Geo document) {

    }

    @Override
    public void update(Geo document) {

    }

    @Override
    public void delete(String id) {

    }
}
