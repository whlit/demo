package cn.whlit.spring.es.models;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author WangHaiLong 2023/12/15 16:18
 */
public class Contributor {
    @Field(type = FieldType.Long)
    private Integer id;
    @Field(type = FieldType.Keyword)
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
