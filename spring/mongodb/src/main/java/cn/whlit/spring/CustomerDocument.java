package cn.whlit.spring;

import cn.whlit.spring.util.DocumentUtil;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangHaiLong 2025/1/2 17:56
 */
public class CustomerDocument {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDocument.class);
    private final Document document;

    public CustomerDocument(Document document) {
        this.document = document;
    }

    public String getId() {
        ObjectId id = document.getObjectId("_id");
        if (id == null) {
            logger.error("获取id失败: {}", document.toJson());
            return null;
        }
        return id.toString();
    }

    public Integer getInteger(Object key) {
        Object obj = document.get(key, Object.class);
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        caseError(key, obj, Integer.class);
        return null;
    }

    public Long getLong(Object key) {
        Object obj = document.get(key, Object.class);
        switch (obj) {
            case null -> {
                return null;
            }
            case Integer i -> {
                return i.longValue();
            }
            case Long l -> {
                return l;
            }
            default -> caseError(key, obj, Long.class);
        }
        return null;
    }

    private void caseError(final Object key, final Object value, final Class<?> clazz) {
        logger.error("类型转换错误: id: {}, key: {}, 预期类型: {}, 实际类型: {}", getId(), key, clazz, value.getClass());
    }
}
