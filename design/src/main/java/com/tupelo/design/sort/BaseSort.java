package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
 *
 * 从最低位开始，依次进行一次排序
 *
 * 从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 *
 */
public class BaseSort {


	public static void main(String[] args) {

		int[] ints  = {2,6,5,9,7,12,3,4,87,6,49,97,54,24,49};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);

	}

	private static void sort(int[] ints){
		int maxLength = getMaxLength(ints);
		for (int i = maxLength-1; i >= 0; i--) {
			baseSort(ints,i,maxLength);
		}

	}


	private static void baseSort(int[] ints,int index,int maxLength){

		int[][] base = new int[10][0];

		for (int i = 0; i < ints.length; i++) {
			int intIndex = getIntIndex(ints[i], index, maxLength);
			base[intIndex] = appendBucket(base[intIndex],ints[i]);
		}
		int mainIndex = 0;
		for (int[] ints1 : base) {
			if(ints1.length<=0){
				continue;
			}
			for (int i : ints1) {
				ints[mainIndex] = i;
				mainIndex++;
			}
		}

	}

	private static int getIntIndex(int i,int index,int maxLength){
		String s = String.valueOf(i);
		int length = s.length();
		if(length + index < maxLength){
			return 0;
		}
		char c = s.charAt(index - maxLength + length);
		return Integer.parseInt(String.valueOf(c));
	}

	private static int getMaxLength(int[] ints){
		int max = ints[0];
		for (int anInt : ints) {
			if(anInt>max){
				max = anInt;
			}
		}
		return String.valueOf(max).length();
	}





	public static int[] appendBucket(int[] bucket , int anInt){
		int[] ints = Arrays.copyOf(bucket, bucket.length + 1);
		ints[ints.length-1] = anInt;
		return ints;
	}



	public static void swap(int[] ints,int i,int j){
		int tmp = ints[i];
		ints[i] = ints[j];
		ints[j] = tmp;
	}

}
