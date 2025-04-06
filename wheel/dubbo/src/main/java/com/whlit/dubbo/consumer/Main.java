package com.whlit.dubbo.consumer;

import com.whlit.dubbo.DubboServiceFactory;
import com.whlit.dubbo.client.Item;
import com.whlit.dubbo.client.ItemService;

public class Main {

    public static void main(String[] args) {
        DubboServiceFactory serviceFactory = new DubboServiceFactory();
        ItemService service = serviceFactory.getService(ItemService.class);
        Item item = service.getById(1);
        System.out.println(item);
    }
}
