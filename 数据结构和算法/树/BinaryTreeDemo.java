package com.tree;

public class BinaryTreeDemo {
	private HeroNode root;
	public static void main(String[] args) {
		BinaryTreeDemo binaryTree = new BinaryTreeDemo();
		HeroNode root = new HeroNode(1,"A");
		HeroNode root1 = new HeroNode(2,"B");
		HeroNode root2 = new HeroNode(3,"C");
		HeroNode root3 = new HeroNode(4,"D");
		HeroNode root4 = new HeroNode(5,"E");
		
		root.setLeft(root1);
		root1.setLeft(root3);
		root.setRight(root2);
		root2.setLeft(root4);
		
		binaryTree.setRoot(root);
		binaryTree.preOrder();
		System.out.println();
		binaryTree.infixOrder();
		System.out.println();
		binaryTree.postOrder();
	}
	
	public void setRoot(HeroNode root){
		this.root = root;
	}
	
	public void preOrder(){
		if(this.root != null){
			this.root.preOrder();
		}else{
			System.out.println("二叉树为空");
		}
	}
	
	public void infixOrder(){
		if(this.root != null){
			this.root.infixOrder();
		}else{
			System.out.println("二叉树为空");
		}
	}
	
	
	public void postOrder(){
		if(this.root != null){
			this.root.postOrder();
		}else{
			System.out.println("二叉树为空");
		}
	}
}

class HeroNode{
	
	private int no;
	
	private String name;
	
	private HeroNode left;
	
	private HeroNode right;
	
	public HeroNode(int no,String name){
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

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder(){
		//先输出父节点
		System.out.println(this);
		//递归左子节点
		if(this.left != null){
			this.left.preOrder();
		}
		//递归右子节点
		if(this.right != null){
			this.right.preOrder();
		}
	}
	/**
	 * 中序遍历
	 */
	public void infixOrder(){
		//递归左子节点
		if(this.left != null){
			this.left.infixOrder();
		}
		//输出父节点
		System.out.println(this);
		//递归右子节点
		if(this.right != null){
			this.right.infixOrder();
		}

	}
	/**
	 * 后序遍历
	 */
	public void postOrder(){
		//递归左子节点
		if(this.left != null){
			this.left.postOrder();
		}
		//递归右子节点
		if(this.right != null){
			this.right.postOrder();
		}
		//输出父节点
		System.out.println(this);
	}
}
