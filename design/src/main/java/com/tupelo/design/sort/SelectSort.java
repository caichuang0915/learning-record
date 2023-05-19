package com.tupelo.design.sort;


import java.util.Arrays;

/**
 * @Author: caichuang
 * @Date: 2023/3/31 11:38
 */
public class SelectSort {


	public static void main(String[] args) {

		int[] param  = {2,4,87,6,97,54,24,49};
		minIndex(param);
		Arrays.stream(param).forEach(System.out::println);

	}

	private static void minIndex(int[] ints){
		for (int i = 0; i < ints.length; i++) {
			int minNum = ints[i];
			int index = i;
			for (int j = i + 1; j < ints.length; j++) {
				if(ints[j] < minNum){
					minNum = ints[j];
					index = j;
				}
			}
			if(i!=index){
				swap(ints,i,index);
			}
		}
	}

	private static void swap(int[] param,int a,int b){
		int i = param[a];
		param[a] = param[b];
		param[b] = i;
	}


}
