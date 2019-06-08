package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

GOTCAH!  compare nums[1] to the map key not a diff
 */
public class TwoSumUsingMap {

    public int[] twoSum(int[] nums, int target) {
        int[] rv = new int[2];
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        map.put(target - nums[0], 0);
        for (int i=1;i<nums.length;i++){
            Integer matchIdx = map.get(nums[1]);
            if (matchIdx != null) {
                rv[0]=matchIdx;
                rv[1]=i;
                break;
            } else {
                map.put(target - nums[i], i  );
            }
        }
        return rv;
    }

    public static void main(String[] args) {
        TwoSumUsingMap twoSum3 = new TwoSumUsingMap();
//        int target=9;
//        int[] arr= {2,7,11,15};
        int target=6;
        int[] arr= {2,3,4};

        final int[] rv = twoSum3.twoSum(arr, target);
        System.out.println(Arrays.asList(rv[0],rv[1]));
    }

}
