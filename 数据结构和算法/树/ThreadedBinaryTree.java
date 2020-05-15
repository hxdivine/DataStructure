package com.tree;
/**
 * 线索二叉树
 * @author 骄傲的大树
 *
 */
public class ThreadedBinaryTree {
	private HeroNodeDemo root;
	
	public void setRoot(HeroNodeDemo root){
		this.root = root;
	}
	public static void main(String[] args) {
		
		HeroNodeDemo root = new HeroNodeDemo(1,"A");
		HeroNodeDemo node1 = new HeroNodeDemo(2,"B");
		HeroNodeDemo node2 = new HeroNodeDemo(3,"C");
		HeroNodeDemo node3 = new HeroNodeDemo(4,"D");
		HeroNodeDemo node4 = new HeroNodeDemo(5,"E");
		HeroNodeDemo node5 = new HeroNodeDemo(6,"F");
		HeroNodeDemo node6 = new HeroNodeDemo(7,"H");
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.setRoot(root);
		tree.threadedNodes();
		//System.out.println(node5.getRight());
		//System.out.println(node5.getLeft());
		
		tree.threadedInfixList();
		System.out.println();
		tree.threadedPreList();
		System.out.println();
		tree.threadedPostList();
		
	}
	private HeroNodeDemo pre = null;
	
	public void threadedNodes(){
		this.threadedNodes(root);
	}
	/**
	 * 中序线索化
	 */
	public void threadedNodes(HeroNodeDemo node){
		if(node == null){
			return;
		}
		
		threadedNodes(node.getLeft());
		
		if(node.getLeft() == null){
			node.setLeftType(1);
			node.setLeft(pre);
			
		}
		
		if(pre != null && pre.getRight() == null){
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
		
		threadedNodes(node.getRight());
	}
	/**
	 * 中序遍历线索化二叉树
	 */
	public void threadedInfixList(){
		HeroNodeDemo node = root;
		while(node != null){
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);

			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			
			node = node.getRight();
		}
	}
	
	/**
	 * 前序遍历线索化二叉树
	 */
	public void threadedPreList(){
		HeroNodeDemo node = root;
		while(node != null){
			while (node.getLeftType() == 0) {
				System.out.println(node);
				node = node.getLeft();
			}
			
			System.out.println(node);
			while (node.getRightType() == 1) {
				node = node.getRight();
				
			}
			node = node.getRight();
		}
	}
	/**
	 * 后序遍历线索化二叉树
	 */
	public void threadedPostList(){
		HeroNodeDemo node = root;
		while(node != null){
			while (node.getLeftType() == 0) {	
				node = node.getLeft();
			}
			
			System.out.println(node);
			if(node.getLeft() != null && node.getLeft() != root){
				System.out.println(node.getLeft());
			}
			while (node.getRightType() == 1) {
				node = node.getRight();
			}
			
			node = node.getRight();
		}
		System.out.println(root);
	}

}
class HeroNodeDemo{
	private int no;
	
	private String name;
	
	private HeroNodeDemo left;
	
	private HeroNodeDemo right;
	
	private int leftType;
	
	private int rightType;
	
	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public HeroNodeDemo(int no,String name){
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNodeDemo getLeft() {
		return left;
	}

	public void setLeft(HeroNodeDemo left) {
		this.left = left;
	}

	public HeroNodeDemo getRight() {
		return right;
	}

	public void setRight(HeroNodeDemo right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNodeDemo [no=" + no + ", name=" + name + "]";
	}

}