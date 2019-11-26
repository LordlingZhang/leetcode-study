package com.zhangyu.study.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyu
 * @description 出现频率最多的k元素
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20排序.md#1-出现频率最多的-k-个元素
 * @date 2019/11/26
 */
@Slf4j
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,3,4,4,2,1,3,3,2,1,1};
//        int[] nums = {1,1,1,2,2,3};
        topK(nums, 2);

    }

    /**
     * 找出出现频率最高的前几位数字
     * 原理：1、先把每种数字的数量计算出来
     *        2、把各个数量相同的归类，放在数组中，此举相当于排序
     *        3、从后往前 依次 往输出集合中 塞值
     *
     * @param nums
     * @param k
     */
    public static void topK(int[] nums, int k){
        // 设置map， key-原数组的元素，value-元素的个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 创建数组，按元素的个数 对应 到 相应的位置上
        // 该操作其实也是 顺便作为排序了
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer enty : map.keySet()){
            Integer pinLv = map.get(enty);
            if (buckets[pinLv] == null){
                buckets[pinLv] = new ArrayList<>();
            }
            buckets[pinLv].add(enty);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            // 如果此集合中的数量  小于 当前 容器剩余空间，直接放进去
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                // 说明此集合中的数量  大于  容器剩余空间 ， 取前几个放进去
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        log.info("结果：{}", topK);

    }

}
