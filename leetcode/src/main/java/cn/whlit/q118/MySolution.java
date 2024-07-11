package cn.whlit.q118;
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics 数组 动态规划 👍 1042 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @auther WangHaiLong 2023/8/16 12:31
 */
public class MySolution {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 1; i <= numRows; i++) {
//            List<Integer> list = new ArrayList<>();
//            if (i == 1){
//                list.add(1);
//                result.add(list);
//                continue;
//            }
//            if (i ==2){
//                list.add(1);
//                list.add(1);
//                result.add(list);
//                continue;
//            }
//            List<Integer> preList = result.get(i - 2);
//            boolean f = (i) % 2 == 0;
//            int k = (i-1) / 2;
//            for (int j = k; j >= 0; j--) {
//                int t = j == 0 ? 1 : preList.get(j - 1) + preList.get(j);
//                if (!f && j == k){
//                    list.add(t);
//                    continue;
//                }
//                list.add(t);
//                list.add(0, t);
//            }
//            result.add(list);
//        }
//        return result;
//    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        if (numRows == 1){
            return result;
        }
        for (int i = 1; i <= numRows; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    result.get(i).add(1);
                    continue;
                }
                List<Integer> list = result.get(i - 1);
                result.get(i).add(list.get(j) + list.get(j -1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MySolution solution = new MySolution();
        System.out.println(solution.generate(6));
    }
}
