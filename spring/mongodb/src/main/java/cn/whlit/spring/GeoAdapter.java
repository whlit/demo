package cn.whlit.spring;

import cn.whlit.spring.domain.Geo;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.postgis.Point;

import java.util.List;

/**
 * @author WangHaiLong 2024/12/26 16:08
 */
public class GeoAdapter extends Geo {

    public GeoAdapter(Document document) {
        ObjectId id = document.getObjectId("_id");
        this.setId(id.toHexString());
        this.setCountry(document.getString("country"));
        Object obj = document.get("location");
        if (obj instanceof List<?>) {
            List<Double> location = ((List<?>) obj).stream().filter(e -> e instanceof Double).map(e -> (Double) e).toList();
            if (location.size() == 2) {
                Point point = new Point(location.get(0), location.get(1));
            }
        }

    }
}
