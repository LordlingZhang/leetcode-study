package com.zhangyu.study.arithmetic.divide;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @description 给算术加上括号得到不同的计算结果
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20分治.md#1-给表达式加括号
 * Input: "2-1-1".
 *
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Output : [0, 2]
 * @date 2020/1/15
 */
@Slf4j
public class AddParenthess {
    public static void main(String[] args) {
        diffWaysToCompute("2-1");
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
