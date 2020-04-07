package com.recustion;
/**
 * 递归
 * 八皇后问题
 * @author 骄傲的大树
 *
 */
public class Queue8 {
	int Max = 8;
	int[] array = new int[Max];
	static int count = 0;
	public static void main(String[] args) {
		Queue8 queue = new Queue8();
		queue.check(0);
		System.out.println(count);
	}
	/**
	 * 
	 * @param n  放置的第n个皇后
	 */
	public void check(int n) {
		if(n == Max) {
			print();
			return;
		}
		
		for(int i = 0; i < Max; i++) {
			//把当前的n皇后放到第i列
			array[n] = i;
			//判断第i列是否冲突
			if(judge(n)) {
				//不冲突 开始递归
				check(n + 1);
			}
		}
	}
	/**
	 * 判断是否在同一行 同一列 同一斜线
	 * @param n  表示当前行
	 * @return
	 */
	public boolean judge(int n) {
		for(int i = 0; i < n; i++) {
			//array【i】 == array[n] 表示同一位置
			// Math.abs(n-i) == Math.abs(array[n] - array[i]) 同一列
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	public void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
