package com.whlit.mybatis.app.dao.mapper;


import com.whlit.mybatis.Param;
import com.whlit.mybatis.Table;
import com.whlit.mybatis.app.dao.entity.Item;

public interface ItemMapper {

    @Table("item")
    Item selectById(@Param("id") Long id);

    @Table("item")
    Item selectByName(@Param("name") String name);

}
