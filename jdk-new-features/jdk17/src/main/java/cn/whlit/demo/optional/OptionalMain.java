package cn.whlit.demo.optional;

import java.util.List;
import java.util.Optional;

/**
 * @author WangHaiLong 2024/2/19 9:21
 */
public class OptionalMain {

    public static void main(String[] args) {
        Optional<Integer> optionalInteger = Optional.ofNullable(null);
        System.out.println(optionalInteger.orElse(2));
        List<Integer> list = optionalInteger.stream().toList();
        System.out.println(list);
        Optional<Integer> or = optionalInteger.or(() -> Optional.of(3));
        System.out.println(or.get());

    }
}
