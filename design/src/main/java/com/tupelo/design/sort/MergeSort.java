package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * @Author: caichuang
 * @Date: 2023/5/18 9:21
 */
public class MergeSort {


	public static void main(String[] args) {
		int[] ints = {32,12,43,1,2,657,123,12,23,543,12,68,45,32};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);
	}


	public static void sort(int[] ints){
		sort(ints,0,ints.length-1);
	}

	public static void sort(int[] ints,int left,int right){
		int mid = (right+left) / 2;
		if(left<right){
			sort( ints, left, mid);
			sort( ints, mid+1, right);
			merge(ints ,left,mid,right);
		}
	}

	public static void merge(int[] ints,int left,int mid,int right){

		// 构建一个临时数组
		int[] temp = new int[right-left+1];
		int k = 0;
		int i = left;
		int j = mid+1;

		// 第一次遍历
		while (i<=mid && j<=right){
			if(ints[i]<ints[j]){
				temp[k] = ints[i];
				i++;
			}else {
				temp[k] = ints[j];
				j++;
			}
			k++;
		}

		while (i<=mid){
			temp[k] = ints[i];
			i++;
			k++;
		}

		while (j<=right){
			temp[k] = ints[j];
			j++;
			k++;
		}

		// 临时数组重新赋值回去
		for (int i1 = 0; i1 < temp.length; i1++) {
			ints[left+i1] = temp[i1];
		}
	}


}
