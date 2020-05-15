package com.tree;
/**
 * 舒徐存储二叉树
 * @author 骄傲的大树
 *
 */
public class ArrBinaryTree {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinary ab = new ArrBinary(arr);
		System.out.println("前序：");
		ab.preOrder();
		System.out.println("中序：");
		ab.infixOrder();
		System.out.println("后序：");
		ab.postOrder();
	}
	
	
}
class ArrBinary{
	private int[] arr;
	
	public ArrBinary(int[] arr){
		this.arr = arr;
	}
	//重载前序
	public void preOrder(){
		this.preOrder(0);
	}
	//重载中序
	public void infixOrder(){
		this.infixOrder(0);
	}
	//重载后序
	public void postOrder(){
		this.postOrder(0);
	}
	/**
	 * 前序遍历
	 * @param index 数组的下标
	 */
	public void preOrder(int index){
		if(arr == null || arr.length == 0){
			System.out.println("数组为空");
		}
		//当前元素
		System.out.println(arr[index]);
		//向左递归
		if((index * 2 + 1) < arr.length){
			preOrder(2 * index + 1);
		}
		//向右递归
		if((index * 2 + 2) < arr.length){
			preOrder(2 * index + 2);
		}
	}
	/**
	 * 中序遍历
	 * @param index
	 */
	public void infixOrder(int index){
		if(arr == null || arr.length == 0){
			System.out.println("数组为空");
		}
		
		//向左递归
		if((index * 2 + 1) < arr.length){
			preOrder(2 * index + 1);
		}
		//当前元素
		System.out.println(arr[index]);

		//向右递归
		if((index * 2 + 2) < arr.length){
			preOrder(2 * index + 2);
		}
	}
	
	/**
	 * 后序遍历
	 * @param index 数组的下标
	 */
	public void postOrder(int index){
		if(arr == null || arr.length == 0){
			System.out.println("数组为空");
		}

		//向左递归
		if((index * 2 + 1) < arr.length){
			preOrder(2 * index + 1);
		}
		//向右递归
		if((index * 2 + 2) < arr.length){
			preOrder(2 * index + 2);
		}
		//当前元素
		System.out.println(arr[index]);
	}
}
