package com.search;
/**
 * 二分查找算法
 * @author 骄傲的大树
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,5,8,16,22,33,44,55,66};
		int arrIndex = binarySearch(arr, 0, arr.length-1, 45);
		System.out.println("数组第" + arrIndex + "个");
	}
	/**
	 * 
	 * @param arr 数组
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param findVal 需要查找值
	 * @return 找到返回下标，没有返回-1
	 */
	public static int binarySearch(int[] arr,int left,int right,int findVal){
		if(left > right){//没有找到
			return -1;
		}
		
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		
		if(findVal > midVal){
			return binarySearch(arr,mid+1,right,findVal);
		}else if(findVal < midVal){
			return binarySearch(arr, left, mid-1, findVal);
		}else{
			return mid;
		}
	}

}
