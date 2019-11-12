package com.zhangyu.study.arithmetic.doublepointer;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @description 交换字符串中元音字母的位置
 * Given s = "leetcode", return "leotcede"
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20双指针.md#3-反转字符串中的元音字符
 *
 * @date 2019/11/12
 */
public class ExchangeVowels {

    private static List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        exchange("aeivoefkdin");
    }

    /**
     * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
     * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
     *
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * 空间复杂度 O(1)：只需要使用两个额外变量
     * @param s
     */
    public static void exchange(String s){

        if (StringUtils.isBlank(s)){
            return;
        }
        int i = 0, j = s.length() - 1;
        char[] export = new char[s.length()];
        while (i <= j){
            char ii = s.charAt(i);
            char jj = s.charAt(j);
            if (!vowelList.contains(ii)){
                export[i++] = ii;
            }else if (!vowelList.contains(jj)){
                export[j--] = jj;
            }else {
                export[i++] = jj;
                export[j--] = ii;
            }
        }
        System.out.println(new String(export));
    }
}
