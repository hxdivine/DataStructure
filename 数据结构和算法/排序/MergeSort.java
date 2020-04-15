package com.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 * @author 骄傲的大树
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {8,6,7,2,1,3,5,4};
		int[] temp = new int[arr.length];
		
		mergeSort(arr,0,arr.length-1,temp);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 分+合的方法
	 * @param arr 原始数组
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param temp 临时数组
	 */
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {

		if(left < right) {
			int mid = (left + right) / 2;
			//左边
			mergeSort(arr,left,mid, temp);
			//右边
			mergeSort(arr,mid+1,right,temp);
			
			merge(arr,left,mid,right,temp);
			System.out.println(Arrays.toString(arr));
		}
		
	}
	/**
	 * 合并的方法
	 * @param arr 原始数组
	 * @param left 左边初始索引
	 * @param mid 中间索引
	 * @param right 右边索引
	 * @param temp 中转数组
	 */
	public static void merge(int[] arr, int left,int mid,int right,int[] temp) {
		int i = left;
		int j =mid + 1;
		int t = 0;// 指向temp数组的当前索引
		
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;
				i++;
			}else {
				temp[t] = arr[j];
				t++;
				j++;
			}
		}
		//原始数组中还有没有加到temp中
		while(true) {
			if(i <= mid) {
				temp[t] = arr[i];
				t++;
				i++;
			}else if(j <= right) {
				temp[t] = arr[j];
				t++;
				j++;
			}else {
				break;
			}
		}
		//将temp拷贝到arr中
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
	}
}
