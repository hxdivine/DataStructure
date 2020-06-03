package com.Algorithen;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法处理公交站问题
 * @author 骄傲的大树
 *
 */
public class KruskalAlgorithm {
	
	private int edgeNum; // 边的个数
	private char[] vertexs; //远点数据
	private int[][] matrix; //邻接矩阵
	//使用INF 表示两个点不连通
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int[][] matrix = {
				{0,12,INF,INF,INF,16,14},
				{12,0,10,INF,INF,7,INF},
				{INF,10,0,3,5,6,INF},
				{INF,INF,3,0,4,INF,INF},
				{INF,INF,5,4,0,2,8},
				{16,7,6,INF,2,0,9},
				{14,INF,INF,INF,8,9,0}};
		KruskalAlgorithm kruskal = new KruskalAlgorithm(vertexs,matrix);
		kruskal.print();
		
		kruskal.kruskal();
	}
	
	public KruskalAlgorithm(char[] vertexs,int[][] matrix){
		int vlen = vertexs.length;
		this.vertexs = new char[vlen];
		for(int i = 0; i < vertexs.length; i++){
			this.vertexs[i] = vertexs[i];
		}
		
		this.matrix = new int[vlen][vlen];
		for(int i = 0; i < vlen; i++){
			for(int j = 0; j < vlen; j++){
				this.matrix[i][j] = matrix[i][j];
			}
		}
		
		//统计边
		for(int i = 0; i < vlen; i++){
			for(int j = i + 1; j < vlen; j++){
				if(this.matrix[i][j] != INF){
					edgeNum++;
				}
				
			}
		}
	}
	public void print(){
		System.out.println("邻接矩阵：");
		for(int i = 0; i < vertexs.length; i++){
			for(int j = 0; j < vertexs.length; j++){
				System.out.printf("%10d\t",matrix[i][j]);
				
			}
			System.out.println();
		}
	}
	/**
	 * 对边进行排序
	 * @param edges
	 */
	private void sortEdges(EData[] edges){
		EData temp = null;
		for(int i = 0; i < edges.length - 1; i++){
			for(int j = 0; j < edges.length - 1 - i; j++){
				if(edges[j].weight > edges[j + 1].weight){
					temp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = temp;
				}
			}
		}
	}
	/**
	 * 
	 * @param ch 原点值
	 * @return 返回ch点对应的下标
	 */
	private int getPosition(char ch){
		for(int i = 0; i < vertexs.length; i++){
			if(vertexs[i] == ch){
				return i;
			}
		}
		return -1;
	}
	/**
	 * 获取图中边并且放入edges[]
	 * @return
	 */
	private EData[] getEdges(){
		int index = 0;
		EData[] edges = new EData[edgeNum]; 
		for(int i = 0; i < vertexs.length; i++){
			for(int j = i + 1; j < vertexs.length; j++){
				if(matrix[i][j] != INF){
					edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
				}
			}
		}
		return edges;
	}
	/**
	 * 获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同
	 * @param ends
	 * @param i
	 * @return
	 */
	private int getEnd(int[] ends,int i){
		while(ends[i] != 0){
			i = ends[i];
		}
		return i;
	}
	
	public void kruskal(){
		int index = 0;
		int[] ends = new int[edgeNum]; //用于保存已有最小生成树中的每个顶点在最小生成树中的终点
		//创建结果数组，保存最后的最小生成树
		EData[] rets = new EData[edgeNum];
		//获取图中所有边的集合
		EData[] edges = getEdges();
		//按边的权重进行从小到大排序
		sortEdges(edges);
		//遍历edges数组
		
		for(int i = 0; i < edgeNum; i++){
			//获取到第i条边的第一个 第二个顶点
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			//获取顶点在已有最小生成树中的终点
			int m = getEnd(ends,p1);
			int n = getEnd(ends,p2);
			//是否生成回路
			if(m != n){
				//设置m在已有最小生成树中的终点为n
				ends[m] = n; 
				rets[index++] = edges[i];
			}
		}
		System.out.println("最小生成树：");
		for(int i = 0; i < index; i++){
			System.out.println(rets[i]);
		}
	}

}
/**
 * 表示一条边
 * @author 骄傲的大树
 *
 */
class EData{
	char start; //边的起点
	char end;   //边的另外一个点
	int weight;
	
	public EData(char start,char end,int weight){
		this.end = end;
		this.start = start;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "EData [<start=" + start + ", end=" + end + ">, weight=" + weight + "]";
	}
	
	
}
