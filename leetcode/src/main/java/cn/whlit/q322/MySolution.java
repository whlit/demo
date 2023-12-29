package cn.whlit.q322;
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2³¹ - 1
// 0 <= amount <= 10⁴
//
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2515 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @auther WangHaiLong 2023/8/16 21:29
 */
public class MySolution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] counts = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                if (counts[i - coin] >= 0 && (counts[i] == 0 || counts[i] > counts[i - coin] + 1)) {
                    counts[i] = counts[i - coin] + 1;
                }
            }
            if (counts[i] == 0){
                counts[i] = -1;
            }
        }
        return counts[amount];
    }

    public static void main(String[] args) {
        System.out.println(new MySolution().coinChange(new int[]{1, 2, 5}, 11));
    }
}
