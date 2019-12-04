package com.zhangyu.study.arithmetic.greedythought;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangyu
 * @description 最少针扎破 所有气球
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * 数组的的两位数分别代表气球的左右两边的位置， 差就是直径
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20贪心思想.md#3-投飞镖刺破气球
 * @date 2019/12/4
 */
@Slf4j
public class ArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] balloons = {{10,16}, {2,8}, {1,6}, {7,12}};
        process(balloons);
    }

    /**
     * z扎破气球
     * 算法思路： 每个气球可能位置会重叠，尽可能的从重叠最多的地方扎破（必然是边缘处重叠可能最多）
     * 先按气球右侧的位置排序，然后设置一个最左边的气球位置，作为初始扎破位置
     * 因为其他的气球最右侧必然在当前选中的右侧，所以，如果其他左边位置在当前选中气球右边位置的左侧，那边就能被扎破
     * @param balloons
     */
    public static void process(int[][] balloons){
        // 1.先排序：按气球右侧位置
        Arrays.sort(balloons, Comparator.comparingInt(o -> o[1]));
        // 2.选取最初的位置
        int count = 1;// 最好的情况也需要一根针，即所有的都叠在一起
        int endpoint = balloons[0][1];
        for (int i = 1; i < balloons.length; i ++ ){
            if (balloons[i][0] < endpoint){
                // 说明重叠在一起，不需要加针
                continue;
            }
            // 不重叠，需要加针,最末尾位置更换
            count ++;
            endpoint = balloons[i][1];
        }
        log.info("一共需要 {} 根针", count);
    }


}
