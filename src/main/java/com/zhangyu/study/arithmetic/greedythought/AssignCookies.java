package com.zhangyu.study.arithmetic.greedythought;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author zhangyu
 * @description 分配饼干的最优解
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#1-分配饼干
 *
 * 题目描述：每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。
 * 求解最多可以获得满足的孩子数量
 * Input: grid[1,3], size[1,2,4]
 * Output: 2
 * @date 2019/11/27
 */
@Slf4j
public class AssignCookies {

    public static void main(String[] args) {
        int[] cookies = {1,2,3,6,8};
        int[] children = {1,1,4,5,9};
        assign(cookies, children);
    }

    /**
     * 输出满足孩子的数量
     * 孩子和饼干都要排序
     * 优先从满足度小的孩子开始分分配，然后往后推
     * @param cookies
     * @param children
     */
    public static void assign(int[] cookies, int[] children){
        // 1.排序
        Arrays.sort(cookies);
        Arrays.sort(children);
        // 2.设置孩子位置和饼干位置
        int childIndex = 0, cookieIndex = 0;
        // 如果孩子或者饼干分配结束，循环结束
        while (childIndex < children.length && cookieIndex < cookies.length){
            // 孩子满足度比 饼干小，分配，然后下一个孩子
            if (children[childIndex] <= cookies[cookieIndex]){
                childIndex ++;
            }
            //不管是否分配成功，都要换下一块饼干
            cookieIndex ++;
        }
        log.info("满足的孩子数量:{}", childIndex);
    }
}
