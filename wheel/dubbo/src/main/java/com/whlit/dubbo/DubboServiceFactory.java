package com.whlit.dubbo;

import com.alibaba.fastjson2.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DubboServiceFactory {

    private HttpClient httpClient = HttpClient.newBuilder().build();

    @SuppressWarnings("all")
    public <T> T getService(Class<T> serviceInterface) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{serviceInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                RequestMessage requestMessage = new RequestMessage();
                requestMessage.setService(serviceInterface.getName());
                requestMessage.setMethod(method.getName());
                requestMessage.setArgs(args);
                HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/dubbo"))
                        .POST(HttpRequest.BodyPublishers.ofString(JSON.toJSONString(requestMessage)))
                        .build();
                String body = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
                return JSON.parseObject(body, method.getReturnType());
            }
        });
    }

    public static void main(String[] args) {
        DubboServiceFactory serviceFactory = new DubboServiceFactory();
    }

}
