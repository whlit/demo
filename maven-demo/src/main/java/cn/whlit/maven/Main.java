package cn.whlit.maven;


import cn.whlit.maven.resource.ResourceLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.sun.source.util.ParameterNameProvider;
import redis.clients.jedis.HostAndPort;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author WangHaiLong 2024/2/4 19:50
 */
public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            List<HostAndPort> list = mapper.readValue(ResourceLoader.class.getClassLoader().getResourceAsStream("config.yaml"), new TypeReference<>() {});
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}