package cn.whlit.spring.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.List;

/**
 * @author WangHaiLong 2025/1/17 18:29
 */
@TableName(value = "demo.item", resultMap = "ResultMap")
public class Item {

    private Integer id;
    @TableField(el = "ext, typeHandler=cn.whlit.spring.handler.JsonHandler")
    private String ext;
    @TableField(el = "props, typeHandler=cn.whlit.spring.handler.ItemPropsHandler")
    private List<Prop> props;
    @TableField(el = "prop, typeHandler=cn.whlit.spring.handler.ItemPropHandler, jdbcType=OTHER")
    private Prop prop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public List<Prop> getProps() {
        return props;
    }

    public void setProps(List<Prop> props) {
        this.props = props;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }
}
