package cn.whlit.q198;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2：
//
//
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
//
// Related Topics 数组 动态规划 👍 2682 👎 0

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @auther WangHaiLong 2023/8/16 13:39
 */
public class MySolution {

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int q = nums[0], p = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //最后一家加上倒数第三家之前的最高金额 与最后一家不偷 两种方式的最大值
            int c = Math.max(nums[i] + q, p);
            q = p;
            p = c;
        }
        ArrayList<String> strings = new ArrayList<>();
        return p;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m -1, j = n -1, k = nums1.length - 1; i >= 0 || j >=0; ){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        System.out.println(new MySolution().rob(nums));
    }
}
