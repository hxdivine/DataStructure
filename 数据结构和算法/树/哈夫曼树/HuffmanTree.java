package com.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 * @author 骄傲的大树
 *
 */
public class HuffmanTree {

	public static void main(String[] args) {
		int[] arr = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}
	public static Node createHuffmanTree(int[] arr){
		List<Node> nodes = new ArrayList<Node>();
		for(int value : arr){
			nodes.add(new Node(value));
		}
		
		while(nodes.size() > 1){
			// 从小到大排序
			Collections.sort(nodes);

			Node left = nodes.get(0);

			Node right = nodes.get(1);
			// 构建新的二叉树
			Node parent = new Node(left.value + right.value);
			parent.setLeft(left);
			parent.setRight(right);
			// 删除tree 加入新的tree
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static void preOrder(Node root){
		if(root == null){
			System.out.println("******");
		}else{
			root.preOrder();
		}
	}
}
//为了让Node对象实现持续排序 使用Collection
class Node implements Comparable<Node>{
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		//从小到大排序
		return this.value - o.value;
	}
	
	//前序遍历
	public void preOrder(){
		System.out.println(this);
		
		if(this.left != null){
			this.left.preOrder();
		}
		
		if(this.right != null){
			this.right.preOrder();
		}
	}
}
