package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * 将数组拆分成多个数组 分别进行希尔排序
 *
 */
public class ShellSort {


	public static void main(String[] args) {

		int[] ints  = {2,6,5,9,7,12,3,4,87,6,49,97,54,24,49};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);

	}

	private static void sort(int[] ints){
		// 首先要进行分组 然后进行插入排序
		for (int step = ints.length/2; step > 0 ; step /= 2) {
			// 每次都进行一次插入排序
			for (int i = step; i < ints.length; i++) {
				// 当前值
				int index = i;
				for (int j = i-step; j >= 0 ; j-=step) {
					if(ints[j]>ints[index]){
						swap(ints,index,j);
						index = j;
					}else {
						break;
					}
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
