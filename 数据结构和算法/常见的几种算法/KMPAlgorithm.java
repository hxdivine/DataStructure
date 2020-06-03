package com.Algorithen;

import java.util.Arrays;

/**
 * KMP算法
 * @author 骄傲的大树
 *
 */
public class KMPAlgorithm {

	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABCDABDE";
		String str2 = "ABCDABD";
		int[] next = kmpNext(str2);
		System.out.println(Arrays.toString(next));
		System.out.println(kmpSearch(str1,str2,next));
	}
	/**
	 * 获取到一个字符串的部分匹配值表
	 * @return
	 */
	public static int[] kmpNext(String dest){
		//创建一个next 数组保存部分匹配值
		int[] next = new int[dest.length()];
		next[0] = 0;
		
		for(int i = 1, j = 0; i < dest.length(); i++){
			//当dest.charAt(i) != dest.charAt(j)，我们需要从next[ j -1]获取j
			//直到我们发现有dest.charAt(i) == dest.charAt(j)成立才退出
			while(j > 0 && dest.charAt(i) != dest.charAt(j)){
				j = next[j - 1];
			}
			
			if(dest.charAt(i) == dest.charAt(j)){
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	/**
	 * 
	 * @param str1 源字符串
	 * @param str2 子串
	 * @param next 部分匹配表
	 * @return -1，不成功，否则返回str1位置
	 */
	public static int kmpSearch(String str1,String str2, int[] next){
		for(int i = 0,j = 0; i < str1.length(); i++ ){
			//需要处理str1.charAt(i) != str2.charAt(j) 调整j的大小
			while(j > 0 && str1.charAt(i) != str2.charAt(j)){
				j = next[j -1];
			}
			
			if(str1.charAt(i) == str2.charAt(j)){
				j++;
			}
			
			if(j == str2.length()){
				return i - j + 1;
			}
		}
		return -1;
	}
}
