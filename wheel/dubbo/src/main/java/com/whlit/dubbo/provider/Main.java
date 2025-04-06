package com.whlit.dubbo.provider;

import com.whlit.dubbo.DubboServer;
import com.whlit.dubbo.ProviderRegister;
import com.whlit.dubbo.client.ItemService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProviderRegister providerRegister = new ProviderRegister();
        providerRegister.register(ItemService.class, new ItemServiceImpl());
        DubboServer dubboServer = new DubboServer(providerRegister);
        dubboServer.start();
    }
}
