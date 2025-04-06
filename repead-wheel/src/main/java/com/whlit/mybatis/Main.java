package com.whlit.mybatis;


import com.whlit.mybatis.app.dao.entity.Item;
import com.whlit.mybatis.app.dao.mapper.ItemMapper;

public class Main {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item item = mapper.selectById(2L);
        System.out.println(item);
        System.out.println(mapper.selectByName("苹果"));
    }
}
