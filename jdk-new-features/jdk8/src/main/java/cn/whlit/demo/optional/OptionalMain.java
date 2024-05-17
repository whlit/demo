package cn.whlit.demo.optional;

import java.util.Map;
import java.util.Optional;

/**
 * @author WangHaiLong 2024/2/19 16:44
 */
public class OptionalMain {

    public static void main(String[] args) {
        Optional<Integer> optionalInteger = Optional.of(1);
        optionalInteger.orElse(2);
    }
}
