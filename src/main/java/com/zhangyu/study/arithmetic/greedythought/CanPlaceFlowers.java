package com.zhangyu.study.arithmetic.greedythought;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description 能否每隔一个位置种一朵花,种n朵
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#7-种植花朵
 * @date 2020/1/3
 */
@Slf4j
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowers = {1,0,0,0,1,0,1};
        place(flowers, 2);
    }

    /**
     * 种花方法
     * 思路：遍历时确认前一个和后一个都是 空的
     * @param flowers 种植花数组
     * @param n         需要种的数量
     */
    public static void place(int[] flowers, int n){
        int len = flowers.length;
        // 还能种植的数量
        int count  = 0;
        for (int i = 0; i < len; i ++){
            // 已经种植的，下一个
            if (flowers[i] == 1){
                continue;
            }
            // 上一个花盆种植情况（第一个花盆不需考虑前一个）
            int pre = i == 0 ? 0 : flowers[i - 1];
            // 下一个花盆种植情况（最后一个花盆不需考虑最后一个）
            int next = i == len - 1 ? 0 : flowers[i + 1];
            if (pre == 0 && next == 0){
                count ++;
                flowers[i] = 1;
            }
        }
        if (count >= n){
            log.info("能种植");
        }else {
            log.info("不能种植");
        }
    }
}
