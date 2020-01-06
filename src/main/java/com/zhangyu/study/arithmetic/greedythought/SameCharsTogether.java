package com.zhangyu.study.arithmetic.greedythought;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @description 分隔字符串，使得不同的字符串之间没有相同的字符串
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij"
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#11-分隔字符串使同种字符出现在一起
 * @date 2020/1/6
 */
@Slf4j
public class SameCharsTogether {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        split(s);
    }

    /**
     * 思想：
     * 记录每个字符 最后的位置
     * 从左往右遍历，先找到当前字符的第一个位置和最后一个位置
     * 然后查看在两个位置中出现的字符，有没有出现在 这个区间之外，如果有的话，则把最后的位置移动到 区间外的那个位置，
     * 直到区间内的字符都这样遍历完
     * @param str
     */
    public static void split(String str){
        // 1.记录每种字符的最靠右的位置(最多26种字母)
        int[] lastIndexArr = new int[26];
        for (int i = 0 ; i < str.length() ; i++){
            lastIndexArr[indexOfStr(str.charAt(i))] = i;
        }
        // 2.遍历查看区间内有没有在外还有的字母
        // 定义当前区间的起始位置
        int firstChar = 0;
        // 定义各区间的数量集合
        List<Integer> qujian = new ArrayList<>();
        while (firstChar < str.length()){
            // 定义当前区间的结束位置
            int endChar = firstChar;
            // 遍历区间内的字符
            for (int j = firstChar; j <= endChar && j < str.length(); j ++){
                // 如果区间内的字符的最靠右位置比当前区间结尾 大，则赋值endChar，即区间右侧右移
                if (lastIndexArr[indexOfStr(str.charAt(j))] > endChar){
                    endChar = lastIndexArr[indexOfStr(str.charAt(j))];
                }
            }
            // 把区间字母的数量保存
            qujian.add(endChar - firstChar + 1);
            // 区间开头重新赋值
            firstChar = endChar + 1;
        }
        log.info("各区间数量:{}", qujian);
    }

    /**
     * 获取当前字符在26个字母中的位置
     * @param c
     * @return
     */
    public static int indexOfStr(char c){
        return c - 'a';
    }
}
