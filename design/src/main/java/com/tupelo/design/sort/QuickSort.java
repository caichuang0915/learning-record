package com.tupelo.design.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author: caichuang
 * @Date: 2023/3/31 11:38
 */
public class QuickSort {


	public static void main(String[] args) {

//		int[] param  = {2,4,87,6,97,54,24,49};
		int[] param  = {87,6};




		qs(param,0,param.length-1);
		System.out.println(JSON.toJSONString(param));


	}


	private static void qs(int[] param,int left ,int right){

		if(left>=right){
			return;
		}

		int partition = partition(param, left, right);

		qs(param,left,partition-1);
		qs(param,partition+1,right);

	}

	private static int partition(int[] param,int left ,int right){

		int pivot = param[left];
		int index = left;

		while (left<right){
			while (right>left){
				if(param[right] < pivot){
					swap(right,index,param);
					index = right;
					left++;
					break;
				}
				right--;
			}
			while (right>left){
				if(param[left] > pivot){
					swap(left,index,param);
					index = left;
					right--;
					break;

				}
				left++;
			}
		}
		return index;
	}


	private static void swap(int a,int b,int[] param){
		int i = param[a];
		param[a] = param[b];
		param[b] = i;
	}


}
