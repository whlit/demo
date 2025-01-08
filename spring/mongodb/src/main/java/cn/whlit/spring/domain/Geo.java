package cn.whlit.spring.domain;

import java.awt.*;

/**
 * @author WangHaiLong 2024/12/26 16:06
 */
public class Geo {
    private String id;
    private String country;
    private Point point;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
