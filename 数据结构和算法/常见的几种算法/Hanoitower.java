package com.Algorithen;
/**
 * 分支算法解决汉诺塔问题
 * @author 骄傲的大树
 *
 */
public class Hanoitower {

	public static void main(String[] args) {
		hanoiTower(3,'A','B','C');
	}
	
	/**
	 * 汉诺塔移动方法
	 * @param num 盘数
	 * @param a 第一个塔
	 * @param b 辅助塔
	 * @param c 目标塔
	 */
	public static void hanoiTower(int num,char a,char b,char c){
		if(num == 1){
			System.out.println("第1个盘从" + a + "->" + c);
		}else{
			//1. 先把最上面 A->B
			hanoiTower(num - 1, a, c, b);
			//2. 把下边的盘 A->C
			System.out.println("第" + num + "个盘从" + a + "->" + c);
			//3. 把B塔的所有盘从 B->C
			hanoiTower(num - 1, b,a,c);
		}
	}
}
