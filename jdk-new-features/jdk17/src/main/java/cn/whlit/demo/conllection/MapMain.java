package cn.whlit.demo.conllection;

import java.util.Map;

/**
 * @author WangHaiLong 2024/2/18 21:04
 */
public class MapMain {

    public static void main(String[] args) {
        Map<String, String> map = Map.of("a", "a", "b", "b");
        System.out.println(map);
        Map<String, String> copyOfMap = Map.copyOf(map);
        System.out.println(copyOfMap);

        Map<String, String> ofEntries = Map.ofEntries(Map.entry("a", "b"), Map.entry("b", "b"));
        System.out.println(ofEntries);

        //Map.of 创建的集合是不可变集合
//        map.put("c", "c");

        //Map.copyOf 创建的集合是不可变集合
//        copyOfMap.put("c", "c");
//        Map<String, String> copyOfHashMap = Map.copyOf(new HashMap<>());
//        copyOfHashMap.put("c", "c");

        //Map.ofEntries 创建的集合是不可变集合
//        ofEntries.put("c", "c");

        //Map.entry 创建的entry也是不可变的
//        Map.Entry<String, String> entry = Map.entry("c", "c");
//        entry.setValue("d");

    }

}
