package com.Algorithen;

import java.util.Arrays;

/**
 * 普利姆算法
 * 村庄修路
 * @author 骄傲的大树
 *
 */
public class PrimAlgorithm {

	public static void main(String[] args) {
		char[] data = new char[]{'S','B','C','D','E','F','G'};
		int verxs = data.length;
		//邻接矩阵的关系使用二位数组表示，10000这个大数，表示两个点不连通
		int[][] weight = {
				{10000,5,7,10000,10000,10000,2},
				{5,10000,10000,9,10000,10000,3},
				{7,10000,10000,10000,8,10000,10000},
				{10000,9,10000,10000,10000,4,10000},
				{10000,10000,8,10000,10000,5,4},
				{10000,10000,10000,4,5,10000,6},
				{2,3,10000,10000,4,6,10000}};
		MGraph mGraph = new MGraph(verxs);
		MinTree minTree = new MinTree();
		minTree.createGraph(mGraph, verxs, data, weight);
		
		minTree.prim(mGraph, 5);
		minTree.showGraph(mGraph);
	}

}
/**
 * 最小生成树
 * @author 骄傲的大树
 *
 */
class MinTree{
	public void createGraph(MGraph graph,int verxs,char data[],int[][] weight){
		
		for(int i = 0; i < verxs; i++){
			graph.data[i] = data[i];
			for(int j = 0; j < verxs; j++){
				graph.weight[i][j] = weight[i][j];
			}
		}
	}
	/**
	 * 得到最小生成树
	 * @param graph
	 */
	public void showGraph(MGraph graph){
		for(int[] link : graph.weight){
			System.out.println(Arrays.toString(link));
		}
	}
	
	public void prim(MGraph graph,int v){
		//标记节点是否访问过
		int[] visited = new int[graph.verxs];
		//visited[] 默认都是0，表示没有访问过
		visited[v] = 1;
		
		int h1 = -1;
		int h2 = -1;
		int minWeight = 10000;
		for(int i = 1; i < graph.verxs; i++){
			for(int j = 0; j < graph.verxs; j++){
				for(int k = 0; k < graph.verxs; k++){
					if(visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight){
						minWeight = graph.weight[j][k];
						h1 = j;
						h2 = k;
					}
					
				}
			}
			System.out.println("边 <" + graph.data[h1] + "," + graph.data[h2] + ">,权值：" + minWeight );
			visited[h2] = 1;
			minWeight = 10000;
		}
	}
}

class MGraph{
	int verxs; //表示图的结点个数
	char[] data; //存放节点数据
	int[][] weight; //存放边，邻接矩阵
	
	public MGraph(int verxs){
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}
