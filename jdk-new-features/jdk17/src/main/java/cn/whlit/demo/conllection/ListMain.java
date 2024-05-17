package cn.whlit.demo.conllection;

import java.util.*;

/**
 * @author WangHaiLong 2024/2/18 21:23
 */
public class ListMain {
    public static void main(String[] args) {
        newFeature();
    }


    public static void newFeature() {
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list);
        List<Integer> copyOfList = List.copyOf(list);
        System.out.println(copyOfList);

        // List.of 创建的集合是不可变集合
//        list.add(1);

        // List.copyOf 方法复制的集合也是不可变集合
//        copyOfList.add(1);
//        List<Object> copyOfArrayList = List.copyOf(new ArrayList<>());
//        copyOfArrayList.add(1);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        List<Integer> copyOfArrayList = List.copyOf(arrayList);
//        copyOfArrayList.add(1);
    }
}
