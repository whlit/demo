package cn.whlit.q11;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 返回容器可以储存的最大水量。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
//
//
// 提示：
//
//
// n == height.length
// 2 <= n <= 10⁵
// 0 <= height[i] <= 10⁴
//
//
// Related Topics 贪心 数组 双指针 👍 4650 👎 0
/**
 * @auther WangHaiLong 2023/10/27 12:32
 */
public class MySolution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length -1, result = 0;
        while (i < j){
            result = Math.max(result, height[i] > height[j] ? (j - i) * height[j--] : (j - i) * height[i++]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        MySolution mySolution = new MySolution();
        JSONArray array = JSON.parseArray(Files.newInputStream(Paths.get("D:\\work\\demo\\leetcode\\src\\main\\java\\cn\\whlit\\q11\\test.json")));
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            int[] ints = jsonObject.getList("arr", int.class).stream().mapToInt(Integer::intValue).toArray();
            int i1 = mySolution.maxArea(ints);
            System.out.println(i1);
        }
    }
}

