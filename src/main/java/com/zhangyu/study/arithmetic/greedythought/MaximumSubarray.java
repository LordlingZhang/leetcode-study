package com.zhangyu.study.arithmetic.greedythought;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description 获取数组中的子数组最大的值
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 子数组最少包含1个
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#10-子数组最大的和
 * @date 2020/1/6
 */
@Slf4j
public class MaximumSubarray {

    public static void main(String[] args) {
        sum(new int[]{1,-4,3,0,3,4,-4,2,-1,2});
    }

    public static void sum(int[] array){
        // 定义当前加完的值
        int preNum = array[0];
        // 定义当前最大值
        int max = preNum;
        for (int n=1 ; n < array.length; n++){
            // 如果当前是 负数，那么没有必要加后一个数，直接取后一个数，然后与当前最大值对比，取最大值
            preNum = preNum > 0 ? preNum + array[n] : array[n];
            max = Math.max(preNum, max);
        }
        log.info("子数组最大值:{}", max);
    }

}
