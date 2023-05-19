package com.tupelo.design.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 当前数值和前面的数据进行比较 如果前面的数值比较大 则交换
 */
public class InsertSort {


	public static void main(String[] args) {

		int[] ints  = {2,6,5,9,7,12,3,4,87,6,49,97,54,24,49};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);

	}

	private static void sort(int[] ints){
		for (int i = 0; i < ints.length; i++) {
			int index = i;
			for (int j = i - 1; j >= 0 ; j--) {
				if(ints[index] < ints[j]){
					swap(ints,index,j);
					index--;
				}else {
					break;
				}
			}
		}
	}



	public static void swap(int[] ints,int i,int j){
		int tmp = ints[i];
		ints[i] = ints[j];
		ints[j] = tmp;
	}

}
