package com.zhangyu.study.arithmetic.doublepointer;

/**
 * @author zhangyu
 * @description 最长子序列
 * @date 2019/11/15
 */
public class LongestWordInDictionary {

    /**
     * 判断target是否是s的子列，即删掉s中的多个字符，能与target一样
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
