package com.search;

import java.util.Arrays;

/**
 * 斐波那契查找算法
 * @author 骄傲的大树
 *
 */
public class FIbonacciSearch {

	public static int maxSize = 20;
	public static void main(String[] args) {
		int[] arr = {1,8,12,88,1000,1456};
		int index = fibSearch(arr, 81);
		
		System.out.println("数组下标位置index = " + index);
	}
	/**
	 * 
	 * 需要先得到一个斐波那契数列
	 * @return
	 */
	public static int[] fib(){
		int[] f =new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i < maxSize; i++){
			f[i] = f[i-1] + f[i-2];
		}
		return f;
	}
	/**
	 * 查找算法
	 */
	public static int fibSearch(int[] a,int key){
		int low = 0;
		int high = a.length - 1;
		int k = 0;//斐波那契分割数据的下标
		int mid = 0;
		int f[] = fib();
		//获取分割数组下标
		while(high > f[k] - 1){
			k++;
		}
		//因为f[k]值可能大于a的长度，因此需要使用Arrays类，构造一个新的数组，并指向a[]
		int[] temp = Arrays.copyOf(a, f[k]);
				
		for(int i = high + 1; i < temp.length; i++){
			temp[i] = a[high];
		}
		
		while(low <= high){
			mid = low + f[k - 1] - 1;
			if(key < temp[mid]){
				high = mid - 1;
				k--;
			}else if(key > temp[mid]){
				low = mid + 1;
				k -= 2;
			}else{
				if(mid <= high){
					return mid;
				}else{
					return high;
				}
			}
		}
		return -1;
	}
}
