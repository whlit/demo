package cn.whlit.maven.stream;

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
