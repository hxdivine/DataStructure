package com.tree;

import java.util.Arrays;

/**
 * 堆排序
 * @author 骄傲的大树
 *
 */
public class HeapSort {
	
	public static void main(String[] args){
		int[] arr = {4,8,95,14,3};
		heapSort(arr);
	}
	/*
	 * 编写一个堆排序的方法
	 */
	public static void heapSort(int arr[]){
		int temp = 0;
		for(int i = arr.length / 2 - 1; i >= 0; i--){
			adjustHeap(arr,i,arr.length);
		}
		for(int j = arr.length - 1; j > 0; j--){
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 调整成大顶堆
	 * @param arr 待调整数组
	 * @param i 表示非叶子节点在数组中的索引
	 * @param length表示堆多少个元素继续调整，length是减少的
	 */
	public static void adjustHeap(int arr[],int i,int length){
		int temp = arr[i];
		for(int k = i * 2 + 1; k < length; k = k * 2 +1){
			if(k + 1 < length && arr[k] < arr[k + 1]){
				k++;
			}
			if(arr[k] > temp){
				arr[i] = arr[k];
				i = k;
			}else{
				break;
			}
		}
		
		arr[i] = temp;
	}
}
