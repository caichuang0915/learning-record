package com.tupelo.algorithm;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class Nconvert {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int num = 4; // PINALSIGYAHRPI

//		System.out.println(convert(s,num));
		System.out.println(getRowStr(s,num,2));
	}

	public static String convert(String s, int numRows) {

		for (int i = 0; i < numRows; i++) {




		}



		return "";
	}

	public static String getRowStr(String s,int numRows,int row){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int x = ( (numRows - 2 * row) * 2 + 1 + 1 ) * i  + row - 1;
			if(x>s.length()-1){
				break;
			}
			sb.append(s.charAt(x));
		}
		return sb.toString();

	}
}
