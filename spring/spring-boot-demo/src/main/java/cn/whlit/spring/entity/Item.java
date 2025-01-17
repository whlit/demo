package cn.whlit.spring.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author WangHaiLong 2025/1/17 18:29
 */
@TableName("demo.item")
public class Item {

    private Integer id;
    @TableField(el = "ext, typeHandler=cn.whlit.spring.handler.JsonHandler")
    private String ext;

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
}
