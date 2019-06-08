package array;

import java.util.*;

public class TwoSum {


    static int[] twoSum(int[] nums, int target) {
            int rv[] = new int[2];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i=0;i<nums.length;i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff) ) {
                    rv[0]=map.get(diff);
                    rv[1]=i;
                    return rv;
                } else {
                    map.put(diff, i);
                }
            }
            return rv;
    }

    public static void main(String[] args) {
        int arr [] = {9,3,5,6,3,2};
        int rv[] = twoSum(arr, 9);
        System.out.println(Arrays.toString(rv));

    }
}
