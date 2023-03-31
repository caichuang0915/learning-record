package com.tupelo.design.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author: caichuang
 * @Date: 2023/3/31 11:38
 */
public class BubbleSort {


	public static void main(String[] args) {

		int[] param  = {2,4,87,6,97,54,24,49};


//		for (int i = 0; i < param.length; i++) {
//			int one = param[i];
//			for (int j = i+1; j < param.length; j++){
//				int two = param[j];
//				if(one > two){
//					swap(i,j,param);
//					one = param[i];
//				}
//			}
//		}


		for (int i = 0; i < param.length-1; i++) {
			for (int j = 0; j < param.length-i-1; j++){
				if(param[j] > param[j+1]){
					swap(j,j+1,param);
				}
			}
		}

		System.out.println(JSON.toJSONString(param));


	}

	private static void swap(int a,int b,int[] param){
		int i = param[a];
		param[a] = param[b];
		param[b] = i;
	}


}
