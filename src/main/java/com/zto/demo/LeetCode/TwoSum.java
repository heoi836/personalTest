package com.zto.demo.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: huangchaofan
 * @create: 2018/12/17 9:34
 */
public class TwoSum {

    /**
     *
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */

    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0 ; i < nums.length; i++){
            Integer index = map.get(target - nums[i]);
            if ( index!= null) {
                result = new int[]{i,index};
                return  result;
            }
        }
        return result;
    }


}
