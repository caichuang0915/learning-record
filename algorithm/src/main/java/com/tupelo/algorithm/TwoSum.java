package com.tupelo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: caichuang
 * @Date: 2023/5/17 11:31
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] a = {2,7,11,15};
		int[] ints = twoSum(a, 9);
		System.out.println(ints);

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int other = target-num;
			Integer index = map.get(other);
			if(null!=index){
				return new int[]{i, index};
			}
			map.put(num,i);
		}
		return null;
	}
}
