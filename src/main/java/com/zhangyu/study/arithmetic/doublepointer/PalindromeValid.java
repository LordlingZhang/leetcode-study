package com.zhangyu.study.arithmetic.doublepointer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangyu
 * @description 回文字符串校验
 * 可以删除一个字符，判断是否能构成回文字符串。
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20双指针.md#3-反转字符串中的元音字符
 * @date 2019/11/12
 */
@Slf4j
public class PalindromeValid {

    public static void main(String[] args) {
        String s = "asdfgeqfdsa";
        if (valid(s)){
            log.debug("校验正确");
        }else {
            log.debug("校验不正确");
        }
    }

    /**
     * 本题的关键是处理删除一个字符。在使用双指针遍历字符串时，如果出现两个指针指向的字符不相等的情况，我们就试着删除一个字符，再判断删除完之后的字符串是否是回文字符串。
     * 在判断是否为回文字符串时，我们不需要判断整个字符串，因为左指针左边和右指针右边的字符之前已经判断过具有对称性质，所以只需要判断中间的子字符串即可。
     * 在试着删除字符时，我们既可以删除左指针指向的字符，也可以删除右指针指向的字符。
     * @param s
     * @return
     */
    public static boolean valid(String s){
        if (StringUtils.isBlank(s)){
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i < j){
            // 如果两边的不一样
            if (s.charAt(i) != s.charAt(j)){
                // 左边右移1位 或者 右边左移1位   ，看是否相等
                return remainValid(s, i + 1, j) || remainValid(s, i, j - 1);
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * 校验剩余的是否是回文
     * @param s
     * @param i
     * @param j
     * @return
     */
    public static boolean remainValid(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
