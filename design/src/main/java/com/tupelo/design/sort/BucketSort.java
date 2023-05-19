package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * 桶排序
 *
 * 将数据分别分到几个桶里面去 每个桶的数据都排序 最后再合并
 */
public class BucketSort {


	public static void main(String[] args) {

		int[] ints  = {2,6,5,9,7,12,3,4,87,6,49,97,54,24,49};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);

	}

	private static void sort(int[] ints){
		bucketSort(ints,4);

	}


	private static void bucketSort(int[] ints,int num){
		int max = ints[0];
		int min = ints[0];
		for (int i = 1; i < ints.length; i++) {
			if(ints[i]>max){
				max = ints[i];
			}
			if(ints[i]<min){
				min = ints[i];
			}
		}

		// 计算桶的容量
		int count =  (max - min) / num + 1;
		int[][] bucket = new int[num][0];
		for (int anInt : ints) {
			int index = (anInt - min) / count;
			bucket[index] = appendBucket(bucket[index],anInt);
		}
		int mainIndex = 0;
		for (int[] ints1 : bucket) {
			if(ints1.length<=0){
				continue;
			}
			for (int i = 0; i < ints1.length; i++) {
				int index = i;
				for (int j = i-1; j >= 0; j--) {
					if(ints1[j]>ints1[index]){
						swap(ints1,index,j);
						index--;
					}
				}
			}
			for (int i : ints1) {
				ints[mainIndex] = i;
				mainIndex++;
			}
		}
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
