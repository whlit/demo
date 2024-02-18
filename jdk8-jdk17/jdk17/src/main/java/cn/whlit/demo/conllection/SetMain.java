package cn.whlit.demo.conllection;

import java.util.List;
import java.util.Set;

/**
 * @author WangHaiLong 2024/2/18 21:23
 */
public class SetMain {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3);
        System.out.println(set);
        Set<Integer> copyOfSet = Set.copyOf(set);
        System.out.println(copyOfSet);

        //Set.of 方法不能存在重复元素
//        Set<Integer> set1 = Set.of(1, 2, 1);
//        System.out.println(set1);

        // Set.of 创建的集合也是不可变集合
//        set.add(1);

        List<Integer> list1 = List.of(1, 1, 2);
        // Set.copyOf 方法的入参集合是可以存在重复的元素的
        Set<Integer> set1 = Set.copyOf(list1);
        System.out.println(set1);

        // Set.of 创建的集合是不可变集合
//        set.add(1);

        // Set.copyOf 复制的集合是不可变集合
//        copyOfSet.add(1);
//        Set<Integer> copyOfHashSet = Set.copyOf(new HashSet<>());
//        copyOfHashSet.add(1);
    }
}
