package com.leetcode.no0001;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        return twoSumHash(nums, target);
    }

    /*
    几秒前	通过	37 ms	37.6 MB	java
     */

    private int[] twoSumForce(int[] nums, int target){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int target_int = target - nums[i];
            for(int j = i+1; j < len; j++){
                if(nums[j] == target_int){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
    几秒前	通过	11 ms	39 MB	java
     */

    private int[] twoSumHash(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int target_int = target - nums[i];
            if( hashMap.containsKey(target_int) && hashMap.get(target_int) != i){
                return new int[]{i, hashMap.get(target_int)};
            }
        }
        return null;
    }

    /*
    几秒前	通过	7 ms	41 MB	java
     */

    private int[] twoSumHashBetter(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int target_int = target - nums[i];
            if(hashMap.containsKey(target_int)){
                return new int[]{i, hashMap.get(target_int)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

}
