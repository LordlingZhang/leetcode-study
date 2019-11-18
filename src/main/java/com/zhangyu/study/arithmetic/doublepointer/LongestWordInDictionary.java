package com.zhangyu.study.arithmetic.doublepointer;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @description 最长子序列
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20双指针.md#7-最长子序列
 * @date 2019/11/15
 */
public class LongestWordInDictionary {

    public static void main(String[] args) {
        String s = "sfafgaerdd";
        List<String> d = Arrays.asList("faerd", "dg", "sfafgadd", "fga");
        getLongestStr(s, d);
    }

    /**
     * 获取最长的符合的子列
     * @param s
     * @param d
     */
    public static void getLongestStr(String s, List<String> d){
        String longStr = "";
        for (String str : d){
            int len1 = longStr.length(), len2 = str.length();
            // 当前最长序列 比 循环的长，或者一样长，但是首字母排前
            if (len1 > len2 || (len1 == len2 && longStr.compareTo(str) < 0)){
                continue;
            }
            if (judgeInStr(s, str)){
                longStr = str;
            }
        }
        System.out.println("最长序列：" + longStr);

    }

    /**
     * 判断target是否是s的子列，即删掉s中的多个字符，能与target一样
     * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
     * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
     * @param s
     * @param target
     * @return
     */
    public static boolean judgeInStr(String s, String target){
        if (s.length() < target.length()){
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()){
            if (s.charAt(i) == target.charAt(j)){
                j ++;
            }
            i ++;
        }
        if (j == target.length()){
            return true;
        }
        return false;
    }
}
