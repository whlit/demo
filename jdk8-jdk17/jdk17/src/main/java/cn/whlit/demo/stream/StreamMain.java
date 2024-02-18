package cn.whlit.demo.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author WangHaiLong 2024/2/18 22:41
 */
public class StreamMain {

    public static void main(String[] args) {
        // takeWhile 满足条件的执行，如果不满足条件就跳出循环
        // Stream.of 是通过Arrays.stream(values); 创建的流所以是有序的
        Stream.of("a", "b", "c", "d", "", "e", "f").takeWhile(s -> !s.isEmpty()).forEach(System.out::println);

        System.out.println("---------------------------------");
        // 无序的流是执行满足条件的，直到执行的元素不满足条件跳出循环
        Set.of("a", "b", "c", "d", "", "e", "f").stream().takeWhile(s -> !s.isEmpty()).forEach(System.out::println);

        System.out.println("---------------------------------");

        // dropWhile 是从不满足条件的开始执行
        Stream.of("a", "b", "c", "d", "", "e", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::println);

        System.out.println("---------------------------------");

        // dropWhile 是从第一个不满足条件的开始执行直到结束，之后的不满足条件的也会执行，其中也包括第一个不满足条件的
        Stream.of("a", "b", "c", "d", "", "e", "f", "", "g", "h").dropWhile(s -> !s.isEmpty()).forEach(System.out::println);

        System.out.println("---------------------------------");

        // dropWhile 是从第一个不满足条件的开始执行
        Set.of("a", "b", "c", "d", "", "e", "f", " ", "g", "h").stream().dropWhile(s -> !s.isBlank()).forEach(System.out::println);

        System.out.println("---------------------------------");

        // iterate 是用于方便创建流的方法，这个方法有两个重载 一个是有可以限制创建的流的条件，另一个是创建无限的流
//        IntStream.iterate(2, i -> i+1).forEach(System.out::println); // 创建的无限的流
        IntStream.iterate(2, i -> i < 100, i -> i+1).forEach(System.out::println);

        System.out.println("---------------------------------");

        // Stream.ofNullable 用于防止空指针
        List<Object> list = Stream.ofNullable(null).toList();
        System.out.println(list.size());
//        List<Object> list1 = null;
//        List<Object> list2 = list1.stream().toList();
//        System.out.println(list2.size());
    }

}
