package cn.whlit.q12;
//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
//II 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给你一个整数，将其转为罗马数字。
//
//
//
// 示例 1:
//
//
//输入: num = 3
//输出: "III"
//
// 示例 2:
//
//
//输入: num = 4
//输出: "IV"
//
// 示例 3:
//
//
//输入: num = 9
//输出: "IX"
//
// 示例 4:
//
//
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
//
//
// 示例 5:
//
//
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
//
//
//
// 提示：
//
//
// 1 <= num <= 3999
//
//
// Related Topics 哈希表 数学 字符串 👍 1207 👎 0

import org.apache.commons.lang3.Validate;

/**
 * @auther WangHaiLong 2023/10/27 18:47
 */
public class MySolution {

    public String intToRoman(int num) {
        char[] chars = new char[]{'I','V','X','L','C','D','M'};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0){
            switch (num % 10) {
                case 1:
                    result.append(chars[i]);
                    break;
                case 2:
                    result.append(chars[i]).append(chars[i]);
                    break;
                case 3:
                    result.append(chars[i]).append(chars[i]).append(chars[i]);
                    break;
                case 4:
                    result.append(chars[i+1]).append(chars[i]);
                    break;
                case 5:
                    result.append(chars[i+1]);
                    break;
                case 6:
                    result.append(chars[i]).append(chars[i+1]);
                    break;
                case 7:
                    result.append(chars[i]).append(chars[i]).append(chars[i+1]);
                    break;
                case 8:
                    result.append(chars[i]).append(chars[i]).append(chars[i]).append(chars[i+1]);
                    break;
                case 9:
                    result.append(chars[i+2]).append(chars[i]);
            }
            num /= 10;
            i += 2;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        MySolution m = new MySolution();
        Validate.isTrue("III".equals(m.intToRoman(3)));
        Validate.isTrue("IV".equals(m.intToRoman(4)));
        Validate.isTrue("V".equals(m.intToRoman(5)));
        Validate.isTrue("VI".equals(m.intToRoman(6)));
        Validate.isTrue("IX".equals(m.intToRoman(9)));
        Validate.isTrue("LVIII".equals(m.intToRoman(58)));
        Validate.isTrue("MCMXCIV".equals(m.intToRoman(1994)));

    }

}
