package cn.whlit.q70;

/**
 * @auther WangHaiLong 2023/8/16 12:20
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int result = 0, q = 1, p = 2;
        for (int i = 3; i <= n; i++) {
            result = q + p;
            q = p;
            p = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(5));
    }
}
