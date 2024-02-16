package cn.whlit.maven.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangHaiLong 2024/2/16 11:06
 */
public class DeeCopyTest {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        long oneStart = System.currentTimeMillis();
        JsonNode jsonNode1 = mapper.readTree(new File("D:\\Documents\\Test\\test.json"));
        JsonNode jsonNode2 = mapper.readTree(new File("D:\\Documents\\Test\\test.json"));
        System.out.println(System.currentTimeMillis() - oneStart);

        long twoStart = System.currentTimeMillis();
        JsonNode jsonNode3 = mapper.readTree(new File("D:\\Documents\\Test\\test.json"));
        JsonNode jsonNode4 = jsonNode3.deepCopy();
        System.out.println(System.currentTimeMillis() - twoStart);

    }

    public static void mockJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("D:\\Documents\\Test\\test.json"), mock(new HashMap<>(), 0));
    }

    public static Map<String, Object> mock(Map<String, Object> map, int i) {
        if (i > 5) {
            map.put(RandomStringUtils.randomAlphanumeric(7), RandomStringUtils.randomAlphanumeric(12));
            map.put(RandomStringUtils.randomAlphanumeric(7), RandomStringUtils.randomAlphanumeric(12));
            map.put(RandomStringUtils.randomAlphanumeric(7), RandomStringUtils.randomAlphanumeric(12));
            map.put(RandomStringUtils.randomAlphanumeric(7), RandomStringUtils.randomAlphanumeric(12));
            map.put(RandomStringUtils.randomAlphanumeric(7), RandomStringUtils.randomAlphanumeric(12));
            return map;
        }

        map.put(RandomStringUtils.randomAlphanumeric(5), mock(new HashMap<>(), i + 1));
        map.put(RandomStringUtils.randomAlphanumeric(5), mock(new HashMap<>(), i + 1));
        map.put(RandomStringUtils.randomAlphanumeric(5), mock(new HashMap<>(), i + 1));

        map.put(RandomStringUtils.randomAlphanumeric(5), List.of(
                mock(new HashMap<>(), i + 1),
                mock(new HashMap<>(), i + 1),
                mock(new HashMap<>(), i + 1)
        ));
        return map;
    }
}
