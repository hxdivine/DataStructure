package com.search;

import java.util.Arrays;

/**
 * 插值查找算法
 * @author 骄傲的大树
 *
 */
public class InsertValueSearch {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++){
			arr[i] = i + 1;
		}
	//	System.out.println(arr.length);
		int[] arr1 = {1,52,65,66,77,444,5555,8888};
		int index = insertValueSearch(arr1,0,arr1.length - 1, 52);
		
		System.out.println("数组下标位置index = " + index);
	}
	/**
	 * 
	 * @param arr 数组
	 * @param left 左索引
	 * @param right 右索引
	 * @param findVal 查找值
	 * @return  数组下标
	 */
	public static int insertValueSearch(int[] arr, int left,int right,int findVal){
		if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
			return -1;
		}
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if(findVal > midVal){
			return insertValueSearch(arr,mid + 1,right,findVal);
		}else if(findVal < midVal){
			return insertValueSearch(arr,left,mid - 1,findVal);
		}else{
			return mid;
		}
	}
}
