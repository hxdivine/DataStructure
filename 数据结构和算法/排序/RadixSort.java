package com.sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author 骄傲的大树
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {53,4,65,452,768,3};
		System.out.println(Arrays.toString(arr));
		radixSort(arr);
	}

	public static void radixSort(int[] arr) {
		//定义十个桶
		int[][] bucket = new int[10][arr.length];
		//记录每个桶中存放的有效数据
		int[] bucketElementCounts = new int[10];
		
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >max) {
				max = arr[i];
			}
		}
		//得到最大位数的长度
		int maxlength = (max + "").length();
		
		for(int i = 0, n = 1; i < maxlength;n *= 10, i++) {
			//按位插入到对应的桶中
			for(int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				int x = bucketElementCounts[digitOfElement];
				bucket[digitOfElement][x] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			//将桶中的数据放到数组中
			int index = 0;
			for(int k = 0; k < bucketElementCounts.length; k++) {
				if(bucketElementCounts[k] != 0) {
					for(int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				bucketElementCounts[k] = 0;
			}
			
			System.out.println("第"+ (i+1)+"轮排序："+Arrays.toString(arr));
		}
	}
}
