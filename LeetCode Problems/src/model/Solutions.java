package model;

public class Solutions {
	
	/*
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * You can return the answer in any order.
	 */
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] input = nums;
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int m = nums.length - 1; m > i; m --) {
                if (input[i] + input[m] == target) {
                    result[0] = i;
                    result[1] = m;
                }
            }
        }
        return result;
    }
}
