package cn.whlit.spring.util;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangHaiLong 2025/1/2 17:18
 */
public class DocumentUtil {

    private static final Logger logger = LoggerFactory.getLogger(DocumentUtil.class);

    public static String getString(Document document, final Object key) {
        if (document == null || document.get(key, Object.class) == null) {
            return null;
        }
        return document.get(key, Object.class).toString();
    }

    public static Boolean getBoolean(Document document, final Object key) {
        if (document == null || document.get(key, Object.class) == null) {
            return null;
        }
        Object obj = document.get(key, Object.class);
        if (!(obj instanceof Boolean)) {
            logger.error("类型转换为Boolean错误：key: {}, type: {}", key, obj.getClass());
            return null;
        }
        return (Boolean) obj;
    }

}
