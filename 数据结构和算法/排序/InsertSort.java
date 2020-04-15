package com.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author 骄傲的大树
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {17,20,3,44,16,8,5,30};
		int insertVal = 0;
		int insertIndex = 0;
		for(int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i - 1;
			while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex+1] = insertVal;
			System.out.println(Arrays.toString(arr));
		}
	}
}
