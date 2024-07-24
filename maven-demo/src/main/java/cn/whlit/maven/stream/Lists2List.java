package cn.whlit.maven.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author WangHaiLong 2024/2/6 19:59
 */
public class Lists2List {

    public static void main(String[] args) {
        List<String> list1 = List.of("tom", "jerry", "jack");
        List<String> list2 = List.of("张三", "李四", "王五");
        List<String> list = Stream.concat(list1.stream(), list2.stream()).toList();
        List<Integer> list3 = list.stream().map(String::length).toList();
        List<String> list4 = list.stream().flatMap(s -> Stream.of(s, s.toUpperCase())).toList();
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        List<String> list5 = list.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<Speed> getFinalSpeedList(List<Speed> l1, List<Speed> l2){
        Map<String, Speed> collect = Stream
                .concat(l1.stream(), l2.stream())
                .collect(Collectors.toMap(Speed::getId, Function.identity(), this::compareSpeed));
        return collect.values().stream().toList();
    }
    public Speed compareSpeed(Speed s1, Speed s2){
        //compare ....
        return s1;
    }
}
