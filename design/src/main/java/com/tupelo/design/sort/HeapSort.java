package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 */
public class HeapSort {


	public static void main(String[] args) {

//		int[] ints  = {2,6,5,9,7,12,3,4,87,6,49,97,54,24,49};
		int[] ints  = {2};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);

	}

	private static void sort(int[] ints){
		// 每个元素的 右节点  2n+2 左节点 2n+1  父节点 (n-1)/2
		// 多次构造大根堆 每次排序出来一个数
		// 从最后一个节点的父节点开始循环构建大根堆
		int maxindex = ints.length - 1;
		if(maxindex==0){
			return;
		}
		for (int n = maxindex; n > (maxindex-1)/2; n--) {

			for (int i = (n-1)/2; i >= 0; i--) {
				int left = ints[2*i+1];
				if(left > ints[i]){
					swap(ints,i,2*i+1);
				}
				if(2*i+2 > n){
					continue;
				}
				int right = ints[2*i+2];
				if(right > ints[i]){
					swap(ints,i,2*i+2);
				}
			}
			// 将第n个与第0个交换位置
			swap(ints,0,n);
		}
	}




	public static void swap(int[] ints,int i,int j){
		int tmp = ints[i];
		ints[i] = ints[j];
		ints[j] = tmp;
	}

}
