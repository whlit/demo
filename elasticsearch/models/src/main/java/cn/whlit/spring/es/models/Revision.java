package cn.whlit.spring.es.models;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author WangHaiLong 2023/12/15 16:16
 */
public class Revision {

    @Field(type = FieldType.Long)
    private Integer id;
    @Field(type = FieldType.Long)
    private Integer parentId;
    @Field(type = FieldType.Keyword)
    private String timestamp;
    @Field(type = FieldType.Keyword)
    private String comment;
    @Field(type = FieldType.Keyword)
    private String model;
    @Field(type = FieldType.Keyword)
    private String format;
    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String text;
    @Field(type = FieldType.Long)
    private Integer size;
    @Field(type = FieldType.Keyword)
    private String sha1;
    @Field(type = FieldType.Object)
    private Contributor contributor;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }
}
