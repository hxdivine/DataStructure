package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author 骄傲的大树
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrays = {20,3,6,84,95,-5};
		
		int temp = 0;
		//时间复杂度（O （n^2））
		boolean flag = false;  //优化算法
		for(int i = 0; i < arrays.length-1; i++) {
			for(int j = 0; j < arrays.length - 1 - i; j++) {
				if(arrays[j] > arrays[j+1]){
					flag = true;
					temp = arrays[j];
					arrays[j] = arrays[j+1];
					arrays[j+1] = temp;
				}	
				System.out.println(Arrays.toString(arrays));
		}
			if(!flag) {
				//数组过程中没有进行排序，说明数组已经排序好了
				break;
			}else {
				flag = true;
			}
	}

		for(int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
   }

}
