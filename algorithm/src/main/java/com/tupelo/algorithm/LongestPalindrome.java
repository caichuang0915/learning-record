package com.tupelo.algorithm;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LongestPalindrome {

	public static void main(String[] args) {

		System.out.println(longestPalindrome("a"));
//		System.out.println("asdasdasdasd".substring(1,1));

	}

	public static String longestPalindrome(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			String res = longestPalindrome2(s, i,i);
			if(res.length() > result.length()){
				result = res;
			}

			if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
				String res2 = longestPalindrome2(s, i,i+1);
				if(res2.length() > result.length()){
					result = res2;
				}
			}

		}

		return result;
	}


	public static String longestPalindrome2(String s,int beginIndex,int endIndex) {
		char c = s.charAt(beginIndex);
		int left = beginIndex;
		int right = s.length() - endIndex - 1;

		int start = beginIndex;
		int end = endIndex;

		// 其他
		if(right > 0 && left > 0){
			// 中间
			int min = Math.min(left, right);
			for (int i = 1; i <= min; i++) {
				char r = s.charAt(endIndex + i);
				char l = s.charAt(beginIndex - i);
				if(l!=r){
					break;
				}
				end = endIndex + i;
				start = beginIndex - i;
			}
		}

		// 左侧为0
		if((left<=0 && right > 0) || end==start){
			for (int i = endIndex + 1; i < s.length(); i++) {
				char cur = s.charAt(i);
				if(c!=cur){
					break;
				}
				end = i;
			}
		}

		// 右侧为0
		if((right<=0 && left > 0) || end==start){
			for (int i = beginIndex-1; i >= 0; i--) {
				char cur = s.charAt(i);
				if(c!=cur){
					break;
				}
				start = i;
			}
		}

		return s.substring(start,end + 1);
	}
}
