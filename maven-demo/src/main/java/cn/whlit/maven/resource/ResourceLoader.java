package cn.whlit.maven.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author WangHaiLong 2024/7/22 16:52
 */
public class ResourceLoader {

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        try (InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                return properties;
            }
            properties.load(inputStream);
            return properties;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return properties;
    }

    public static <T> T loadYaml(String path) {
        try (InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                return null;
            }
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static <T> T loadYaml2(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Map<String, List<Map<String, Object>>> map = mapper.readValue(ResourceLoader.class.getClassLoader().getResourceAsStream(path), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                return null;
            }
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
