package com.sort;

import java.util.Arrays;

/**
 * 选择排序算法
 * @author 骄傲的大树
 *
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int[] arr = {20,50,60,1,8,45,26,44};
		int temp = 0;
		//时间复杂度为 O(n^2)
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					System.out.println(Arrays.toString(arr));
				}
				
			}
		}
	}
}
