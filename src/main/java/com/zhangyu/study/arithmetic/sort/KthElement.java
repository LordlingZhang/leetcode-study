package com.zhangyu.study.arithmetic.sort;

import java.util.PriorityQueue;

/**
 * @author zhangyu
 * @description 先排序，然后找出倒数第K个值
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20排序.md#1-kth-element
 * @date 2019/11/22
 */
public class KthElement {

    public static void main(String[] args) {
        int[] nums = {5,42,2,6,4,8,3,10};
        findKthLargest(nums, 2);
//        findKthLargest2(nums, 2);
    }

    /**
     * 快速选择
     * 不需要全部排序，只要最后面k个排好就行了
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        // 正序 数
        k = nums.length - k;

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                // j刚好记录了k位置的值
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        System.out.println(nums[k]);
        return nums[k];
    }

    /**
     *
     * @param a
     * @param l
     * @param h
     * @return
     */
    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            // 交换位置
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    /**
     * 交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 堆排序
     * 使用Priority排序
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            // 维护堆的大小为 K
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
