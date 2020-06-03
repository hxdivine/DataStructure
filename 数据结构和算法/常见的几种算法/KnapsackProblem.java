package com.Algorithen;
/**
 * 动态规划处理背包问题
 * @author 骄傲的大树
 *
 */
public class KnapsackProblem {
	public static void main(String[] args){
		//物品重量 
		int[] w = {1,5,3};
		//物品价值
		int[] val = {1500,3000,2000};
		int m = 4; //物品的容量
		int n = val.length; //物品的个数
		//v[i][]j表示再前i个物品中能够装入容量为jde背包最大价值
		int[][] v = new int[n+1][m+1];
		int[][] path = new int[n+1][m+1];
		for(int i = 0; i < v.length; i++){
			v[i][0] = 0;
		}
		for(int i = 0; i < v[0].length; i++){
			v[0][i] = 0;
		}
		
		for(int i = 1; i < v.length; i++){
			for(int j = 1; j < v[0].length;j++){
				if(w[i-1] > j){
					v[i][j] = v[i-1][j];
				}else{
					//v[i][j] = Math.max(v[i-1][j], v[i-1][j-w[i-1]]+val[i-1]);
					if(v[i-1][j] < v[i-1][j-w[i-1]]+val[i-1]){
						v[i][j] = v[i-1][j-w[i-1]]+val[i-1];
						path[i][j] = 1;
					}else{
						v[i][j] = v[i -1][j];
					}
				}
			}
		}
		
		for(int i = 0; i < v.length; i++){
			for(int j = 0; j < v[i].length;j++){
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
		
		int i = path.length - 1;
		int j = path[0].length - 1;
		while(i > 0 && j > 0){
			if(path[i][j] == 1){
				System.out.printf("第%d个商品放入背包中\n",i);
				j -= w[i -1];
			}
			i--;
		}
	}
}
