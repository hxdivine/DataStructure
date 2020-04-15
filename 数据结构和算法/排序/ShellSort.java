package com.sort;

import java.util.Arrays;

/**
 * 希尔排序算法
 * @author 骄傲的大树
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {8,9,1,7,2,3,5,4,6,0};
		//shellSort(arr);
		System.out.println();
		shellSort1(arr);
	}
	//交换法 耗费时间较长
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		for(int gap = arr.length / 2; gap > 0; gap /= 2) {
			for(int i = gap; i <arr.length; i++) {
				for(int j = i - gap; j >=0; j -= gap) {
					if(arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("希尔排序第"+ (++count) + "排序:  " + Arrays.toString(arr));
		}
	}
	//移动法  从分组开始采用插入排序
	public static void shellSort1(int[] arr) {
		int count = 0;
		for(int gap = arr.length / 2; gap > 0; gap /= 2) {
			for(int i = gap; i < arr.length; i++) {
				//进行插入排序
				int j = i;
				int temp = arr[j];
				if(arr[j] < arr[j - gap]) {
					while(j - gap >= 0 && temp < arr[j - gap]) {
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp;
				}
			}
			System.out.println("希尔排序第"+ (++count) + "排序:  " + Arrays.toString(arr));
		}
	}
}
