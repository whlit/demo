package cn.whlit.q139;

import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.List;

/**
 * @auther WangHaiLong 2023/8/27 13:26
 */
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//
//
//
// 示例 1：
//
//
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//
//
// 示例 2：
//
//
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
//
//
// 示例 3：
//
//
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s 和 wordDict[i] 仅由小写英文字母组成
// wordDict 中的所有字符串 互不相同
//
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2254 👎 0


public class MySolution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && !f[i-1]){
                continue;
            }
            W: for (String word : wordDict) {
                if (i + word.length() > s.length()){
                    continue ;
                }
                for (int j = 0; j < word.length(); j++) {
                    if (s.charAt(i + j) != word.charAt(j)){
                        continue W;
                    }
                }
                f[i + word.length() - 1] = true;
            }
        }
        return f[s.length() -1];
    }

    public static void main(String[] args) {

        Validate.isTrue(!new MySolution().wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
        Validate.isTrue(new MySolution().wordBreak("applepenapple", Arrays.asList(new String[]{"apple", "pen"})));
        Validate.isTrue(new MySolution().wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        Validate.isTrue(new MySolution().wordBreak("bb", Arrays.asList(new String[]{"a","b","bbb","bbbb"})));
        Validate.isTrue(new MySolution().wordBreak("abcd", Arrays.asList(new String[]{"a","abc","b","cd"})));
    }
}

