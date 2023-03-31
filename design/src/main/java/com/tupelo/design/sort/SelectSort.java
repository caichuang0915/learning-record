package com.tupelo.design.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author: caichuang
 * @Date: 2023/3/31 11:38
 */
public class SelectSort {


	public static void main(String[] args) {

		int[] param  = {2,4,87,6,97,54,24,49};
		minIndex(param,0,param.length-1);

		System.out.println(JSON.toJSONString(param));


	}

	private static void minIndex(int[] param,int start,int end){
		if(start>=end){
			return;
		}
		int index = start;
		int min = param[start];

		for (int start1 = start; start1 < param.length; start1++) {
			if(param[start1] < min){
				min = param[start1];
				index = start1;
			}
		}
		swap(param,start,index);
		start++;
		minIndex(param,start,end);
	}



	private static void swap(int[] param,int a,int b){
		int i = param[a];
		param[a] = param[b];
		param[b] = i;
	}


}
