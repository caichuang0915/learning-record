package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 以 数组中的值 作为 临时数组中的 下标  临时数组中的值为当前值的个数
 *
 * 问题： 最大值和最小值相差比较大时会浪费很多空间
 */
public class CountSort {


	public static void main(String[] args) {

		int[] ints  = {2,4,87,6,49,97,54,24,49};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);

	}

	private static void sort(int[] ints){
		int max = ints[0];
		int min = ints[0];
		for (int anInt : ints) {
			if(anInt>max){
				max = anInt;
			}
			if(anInt<min){
				min = anInt;
			}
		}
		int[] temp = new int[max - min + 1];
		for (int i : ints) {
			temp[i-min]++;
		}

		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			int i1 = temp[i];
			if(i1>0){
				for (int i2 = 0; i2 < i1; i2++) {
					ints[index] = i+min;
					index++;
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
