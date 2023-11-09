package cn.whlit.q70;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶
//
// 示例 2：
//
//
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
//
//
//
//
// 提示：
//
//
// 1 <= n <= 45
//
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3179 👎 0

/**
 * @auther WangHaiLong 2023/8/16 11:57
 */
public class MySolution {

    //将已经计算过的结果保存起来，将复杂的问题分解成一个一个小问题
    private int[] temp = {};
    public int climbStairs(int n) {
        temp = new int[n];
        return compute(n);
    }

    private int compute(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (temp[n-2] == 0){
            temp[n-2] = compute(n - 2);
        }
        if (temp[n-1] == 0){
            temp[n-1] = compute(n-1);
        }
        return temp[n-2] + temp[n-1];
    }

    public static void main(String[] args) {
        MySolution solution = new MySolution();
        int i = solution.climbStairs(5);
        System.out.println(i);
    }
}
