package com.zhangyu.study.arithmetic.doublepointer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description  有序数组的 Two Sum
 * 题目描述：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2
 *
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20双指针.md
 * @date 2019/11/8
 */
@Slf4j
public class TwoNumberSum {

    /**
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     */
    public static int[] search(int[] array, int target){
        if (array == null || array.length == 0){
            return null;
        }
        int i = 0, j = array.length - 1;
        while (i < j){
            int sum = array[i] + array[j];
            if (sum == target){
                return new int[]{i + 1, j + 1};
            }else if (sum > target){
                j --;
            }else {
                i ++;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        int[] array = {2, 3,6,8,22,40};
        int target = 28;
        log.info("返回结果：{}:" ,search(array, target));
    }
}
