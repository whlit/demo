package cn.whlit.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther WangHaiLong 2023/8/12 21:31
 */
@Data
public class ItemDTO implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 唯一标识
     */
    private String number;
    /**
     * 名称
     */
    private String name;
}
