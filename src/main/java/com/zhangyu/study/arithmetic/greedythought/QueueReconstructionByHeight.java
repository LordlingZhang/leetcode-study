package com.zhangyu.study.arithmetic.greedythought;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @description 按个子重新排序
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#4-根据身高和序号重组队列
 * @date 2019/12/9
 */
@Slf4j
public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] stus = {{ 7,0 }, {4 , 4}, { 7, 1}, {5 ,0 }, {6 ,1 }, {5 , 2}};
        processSort(stus);
    }

    /**
     * 一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
     * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
     * 关键：身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
     * @param stus
     */
    public static void processSort(int[][] stus) {
        if (stus == null || stus.length == 0){
            return;
        }
        // 先按个子降序，相同的再按后面的升序
        Arrays.sort(stus, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // 应为高个子的都已经再前面排完，矮的都在自己右侧，所有把小的往前移，第二个数字代表自己再第几位
        List<int[]> list = new ArrayList<>();
        for (int[] a : stus){
            list.add(a[1], a);
        }
        log.info("排序结果：{}", JSON.toJSONString(list));
    }

}
