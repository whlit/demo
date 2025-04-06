package com.whlit.dubbo.provider;

import com.whlit.dubbo.client.Item;
import com.whlit.dubbo.client.ItemService;

public class ItemServiceImpl implements ItemService {
    @Override
    public Item getById(Integer id) {
        Item item = new Item();
        item.setId(1);
        item.setName("张三");
        item.setAge(18);
        return item;
    }
}
