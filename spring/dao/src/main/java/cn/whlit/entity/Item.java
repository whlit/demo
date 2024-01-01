package cn.whlit.entity;

import cn.whlit.ItemType;

/**
 * @author WangHaiLong 2024/1/1 16:59
 */
public class Item {

    private Integer id;
    private ItemType type;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
