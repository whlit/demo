package cn.whlit.q279;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
//
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1776 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @auther WangHaiLong 2023/8/16 15:04
 */
public class MySolution {

    public int numSquares(int n) {
        //存储子问题的结果，也就是从小到大的最少平方数的个数
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int m = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                //去掉最大的一个平方数后 用剩下的数的最少值 加上1
                m = Math.min(m, dp[i - j*j]);
            }
            dp[i] = m + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new MySolution().numSquares(5));
    }

}
