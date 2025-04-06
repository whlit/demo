package com.whlit.dubbo;

import com.alibaba.fastjson2.JSON;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.whlit.dubbo.client.ItemService;
import com.whlit.dubbo.provider.ItemServiceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class DubboServer {

    private ProviderRegister register;

    public DubboServer(ProviderRegister register) {
        this.register = register;
    }

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/dubbo", exchange -> {
            RequestMessage message = JSON.parseObject(exchange.getRequestBody(), RequestMessage.class);
            try {
                exchange.sendResponseHeaders(200, 0);
                Object object = register.invoke(message);
                OutputStream os = exchange.getResponseBody();
                os.write(JSON.toJSONBytes(object));
                os.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        server.start();
    }

}
