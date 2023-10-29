package cn.whlit.q14;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字典树 字符串 👍 2967 👎 0

import org.apache.commons.lang3.Validate;

/**
 * @auther WangHaiLong 2023/10/29 16:55
 */
public class MySolution {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        char c = ' ';
        int ci = 0;
        for (int i = 0; i < strs.length; i++) {
            if (ci >= strs[i].length()){
                break;
            }
            char ic = strs[i].charAt(ci);
            if (c != ic){
                if (' ' == c){
                    c = ic;
                }else {
                    break;
                }
            }
            if (i == strs.length -1){
                i = -1;
                ci++;
                c = ' ';
            }
        }
        if (ci > 0){
            return strs[0].substring(0, ci);
        }
        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        Validate.isTrue("fl".equals(mySolution.longestCommonPrefix(new String[]{"flower","flow","flight"})));
        Validate.isTrue("".equals(mySolution.longestCommonPrefix(new String[]{"dog","racecar","car"})));
    }
}
