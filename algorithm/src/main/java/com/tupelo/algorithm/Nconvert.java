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
		String s = "hvdfjhv";
		// PINALSIGYAHRPI
		int num = 1;
		System.out.println(convert(s,num));
	}

	public static String convert(String s, int numRows) {

		StringBuffer[] stringBuffers = new StringBuffer[numRows];
		int step = 2*numRows-2;
		if(0==step){
			return s;
		}
		for (int i = 0; i < s.length(); i = i + step) {
			int start  = i ;
			int end = i + step - 1;
			if(end > s.length() - 1){
				end = s.length() - 1;
			}
			for (int i1 = start; i1 <= end; i1++) {
				int index = i1-start;
				if(i1-start >= numRows){
					index = step - (i1 - start);
				}
				StringBuffer stringBuffer = null == stringBuffers[index] ? new StringBuffer() :  stringBuffers[index];
				stringBuffers[index] = stringBuffer.append(s.charAt(i1));
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (StringBuffer sb : stringBuffers) {
			if(null==sb){
				break;
			}
			stringBuilder.append(sb);
		}
		return stringBuilder.toString();
	}


}
