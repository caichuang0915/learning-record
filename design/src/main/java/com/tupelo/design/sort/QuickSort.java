package com.tupelo.design.sort;

import java.util.Arrays;

/**
 * @Author: caichuang
 * @Date: 2023/5/18 9:21
 */
public class QuickSort {


	public static void main(String[] args) {
		int[] ints = {32,12,43,1,2,657,123,12,23,543,12,68,45,32};
		sort(ints);
		Arrays.stream(ints).forEach(System.out::println);
	}


	// 选择一个基准 大的移动到左边 小的移动到右边

	public static void sort(int[] ints){

		sort(ints, 0, ints.length - 1);

	}


	public static void sort(int[] ints,int left,int right){
		if(left>=right){
			return;
		}
		int i = sortPivot(ints, left, right);
		sort(ints,left,i);
		sort(ints,i+1,right);
	}

	public static int sortPivot(int[] ints,int left,int right){

		int pivot = left;
		int num = ints[pivot];
		while (left<right){
			while (left<right){
				if(ints[right] < num){
					swap(ints,right,pivot);
					pivot = right;
					left++;
					break;
				}
				right--;
			}
			while (left<right){
				if(ints[left] > num){
					swap(ints,left,pivot);
					pivot = left;
					right--;
					break;
				}
				left++;
			}
		}
		return pivot;
	}





	public static void swap(int[] ints,int i,int j){
		int tmp = ints[i];
		ints[i] = ints[j];
		ints[j] = tmp;
	}


}
