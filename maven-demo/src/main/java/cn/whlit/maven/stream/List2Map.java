package cn.whlit.maven.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author WangHaiLong 2024/7/13 19:18
 */
public class List2Map {
    public void main(String[] args) {
        List<User> users = List.of(new User("Tom", 10), new User("Jack", 20),
                new User("Lily", 30));

        Map<Integer, List<String>> map = users.stream().collect(Collectors.groupingBy(
                User::getAge,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().map(User::getName).sorted().toList()
                )
        ));

        Map<String, Map<Integer, List<User>>> map1 = users.stream().collect(
                Collectors.groupingBy(
                        User::getName,
                        Collectors.groupingBy(
                                User::getAge
                        )
                )
        );

    }
    static class User {
        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

    public static void list2Map() {
        List<String> list = List.of("Tom", "Jack", "Lily", "July");
        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (k1, k2) -> k1,
                        HashMap::new
                ));
    }

    public static void list2Map2() {
        List<User> users = List.of(new User("Tom", 10), new User("Jack", 20),
                new User("Lily", 30));
        Map<String, Integer> map = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        User::getAge,
                        (k1, k2) -> k1
                ));
    }
}
