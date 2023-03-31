package com.tupelo.design.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @Author: caichuang
 * @Date: 2023/3/31 15:10
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] param  = {2,4,87,6,97,54,24,49};

//		param = Arrays.copyOfRange(param, 4, param.length);
//		param = Arrays.copyOfRange(param, 4, 5);

		int[] sort = sort(param);
//
		System.out.println(JSON.toJSONString(sort));

	}

	private static int[] sort(int[] param){
		if(param.length<2){
			return param;
		}
		int[] ints = Arrays.copyOf(param, param.length);
		int mid = ints.length/2;
		int[] ints1 = Arrays.copyOfRange(ints, 0, mid);
		int[] ints2 = Arrays.copyOfRange(ints, mid, ints.length);
		return merge(sort(ints1),sort(ints2));
	}


	private static int[] merge(int[] left,int[] right){

		int[] result = new int[left.length + right.length];

		int index = 0;
		while (left.length>0 && right.length>0){
			if(left[0]>right[0]){
				result[index] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}else {
				result[index] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			}
			index++;
		}

		while (left.length>0){
			result[index] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
			index++;
		}

		while(right.length>0){
			result[index] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
			index++;
		}

		return result;
	}
}
