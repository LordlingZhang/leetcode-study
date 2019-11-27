package com.zhangyu.study.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description 荷兰国旗颜色排序问题
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20排序.md#1-按颜色进行排序
 * @date 2019/11/27
 */
@Slf4j
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {0,1,2,1,2,2,1,0,0,2,0,1};
        sort(nums);
    }

    /**
     * 对乱序的数组按 012顺序排序
     *  想法就是 0往前交换，2往后交换，1不动
     * @param nums
     */
    public static void sort(int[] nums){
        // 分别定义假设的  012的初始位置
        int zero = -1, one = 0, two = nums.length -1;
        while (one <= two){
            // 如果one的位置是0，则和zero的值换位置，同时  one指向下面一位
            if (nums[one] == 0){
                swap(nums, ++zero, one++);
            // 如果one的位置是2，则和two的值换位置， 同时 two应为换了之后是2，所以往前移动一位， one换了值之后，不确定当前值，所以位置不变
            }else if (nums[one] == 2){
                swap(nums, one, two--);
            }else {
            // one位置是1，位置往后移
                one++;
            }
        }
        log.info("排序完：{}", nums);
    }

    /**
     * 交换
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
