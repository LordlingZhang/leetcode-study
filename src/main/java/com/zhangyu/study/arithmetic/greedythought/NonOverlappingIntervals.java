package com.zhangyu.study.arithmetic.greedythought;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangyu
 * @description 不重叠的区间个数
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#2-不重叠的区间个数
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * @date 2019/11/29
 */
@Slf4j
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,3},{4,7},{3,5},{7,8}};
        process(nums);
    }

    /**
     * 处理
     * 思路：先按每组数的末尾排序
     *      找出第一个，然后后面每个的开头都需要比前一个大
     *      计算出 排列好的数组的数量，最后用总数相减
     * @param nums
     */
    public static void process(int[][] nums){
        // 1.先排序 按 数据的末尾
        Arrays.sort(nums, Comparator.comparing(o -> o[1]));
        // 2.开始排列
        // 记录已经排列的数组的数量
        int cnt = 1;
        // 记录当前最前面的末尾；
        int tail = nums[0][1];
        for (int i = 1; i <nums.length; i ++){
            if (nums[i][0] < tail){
                // 如果当前数组的开头 比 指向的 末尾小， 则不排进去
                continue;
            }
            tail = nums[i][1];
            cnt ++;
        }
        log.info("需要去掉：{}个", nums.length - cnt);
    }
}
