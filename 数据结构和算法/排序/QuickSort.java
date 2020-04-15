package com.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 * @author 骄傲的大树
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {-9,78,55,0,-15,-66,54};
		quickSort(arr,0,arr.length-1);
		System.out.println();

	}
	
	public static void quickSort(int[] arr,int left,int right) {
		int l = left;
		int r = right;
		int temp = 0;
		//中间值
		int pivot = arr[(l + r) / 2];
		//while循环目的是让pivot小的放到左边，大的放到右边
		while( l < r) {
			//左边找到大于pivot的值
			while(arr[l] < pivot) {
				l += 1;
			}
			//右边找到小于pivot的值
			while(arr[r] > pivot) {
				r -= 1;
			}
			//如果l 》= r说明pivot的左右两边的值，已经全部小于或大于pivot
			if(l >= r) {
				break;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
				
			if(arr[r] == pivot) {
				l += 1;
			}
			if(arr[l] == pivot) {
				r -=1;
			}
		}
		System.out.println(Arrays.toString(arr));
		if(l == r) {
			l += 1;
			r -= 1;
		}
		if(left < r) {
			quickSort(arr,left,r);
		}
		if(right > l) {
			quickSort(arr,l,right);
		}
		
	}
	
}
