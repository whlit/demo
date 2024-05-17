package cn.whlit.demo.conllection;

import java.util.*;

/**
 * @author WangHaiLong 2024/4/2 15:45
 */
public class Coll {

    public static void main(String[] args) {
        map();
    }

    public static void map() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        System.out.println(map);

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "1");
        linkedHashMap.put("b", "2");
        linkedHashMap.put("c", "3");

        System.out.println(linkedHashMap);
    }

    public static void list() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("1");
        list.add("3");
        list.add("2");
        System.out.println(list);

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("1");
        stack.push("3");
        stack.push("2");
        System.out.println(stack);

        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("1");
        queue.add("3");
        queue.add("2");
        System.out.println(queue);

    }

    public static void set() {
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("1");
        set.add("3");
        set.add("2");
        System.out.println(set);

        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("a");
        linkedHashSet.add("1");
        linkedHashSet.add("3");
        linkedHashSet.add("2");
        System.out.println(linkedHashSet);

    }
}
