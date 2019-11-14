package com.zhangyu.study.arithmetic.doublepointer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description 把两个已经排序过的数组合并 到一个数组
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20双指针.md#5-归并两个有序数组
 * @date 2019/11/14
 */
@Slf4j
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1,4,6,0,0,0};
        int[] arr2 = {2,3,5};
        sort(arr1, 3, arr2,3);
    }

    public static void sort(int[] arr1, int num1, int[] arr2, int num2){
        // 记录数组的最后一个位置（即最大的位置）
        int index1 = num1 - 1, index2 = num2 - 1;
        int newIndex = num1 + num2 - 1;

        while (index1 >= 0 || index2 >= 0){
            if (index1 < 0){
                // 说明 arr1 已经排完
                arr1[newIndex--] = arr2[index2--];
            }else if (index2 < 0){
                // 说明 arr2 已经排完
                arr1[newIndex--] = arr1[index1--];
            }else if (arr1[index1] > arr2[index2]){
                arr1[newIndex--] = arr1[index1--];
            }else {
                arr1[newIndex--] = arr2[index2--];
            }
        }
        log.error("排序后：", arr1);
    }
}
