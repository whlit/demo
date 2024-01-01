package cn.whlit.entity;

import cn.whlit.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangHaiLong 2024/1/1 16:59
 */
@Data
@Builder
//添加了Builder注解后，就没有了默认的无参构造函数，只有一个全参的，此时将属性的顺序与mybatis中resultMap中定义的顺序更改为不一致时，会导致异常
@NoArgsConstructor
//添加NoArgsConstructor注解后导致Builder注解的全参构造函数缺失，报错需要添加一个全参的构造函数
@AllArgsConstructor
public class Item {

    private Integer id;
    private ItemType type;
    private String name;

}