package com.tree;

/**
 * 平衡二叉树
 * AVL
 * @author 骄傲的大树
 *
 */
public class AVLTree {

	private Node_A root;
	 
	public static void main(String[] args) {
		//int[] arr = {4,3,5,6,7,8};
		int[] arr = {12,10,8,6,5,2};
		AVLTree avlTree = new AVLTree(); 
		for(int i = 0; i < arr.length; i++){
			avlTree.add(new Node_A(arr[i]));
		}
		avlTree.infixOrder();
		System.out.println("AVL before " + avlTree.root.height());
		System.out.println("AVL left before " + avlTree.root.leftHeight());
		System.out.println("AVL right before " + avlTree.root.rightHeight());
		
	}

	public void add(Node_A node){
		if(root == null){
			root = node;
		}else{
			root.add(node);
		}
	}
	
	public void infixOrder(){
		if(root == null){
			System.out.println("BST is null ");
		}else{
			System.out.println("BST root " + root);
			root.infixOrder();
		}
	}
	public boolean delete(int value){
		if(root == null ){
			return false;
		}else{
			Node_A targetNode = search(value);
			if(targetNode == null){
				return false;
			} 
			if(root.left == null && root.right == null){
				root = null;
			}
			Node_A targetParentNode = searchParent(value);
			
			if(targetNode.left == null && targetNode.right == null){
				if(targetParentNode.left != null && targetParentNode.left.value == targetNode.value){
					targetParentNode.left = null;
				}else if(targetParentNode.right != null && targetParentNode.right.value == targetNode.value){
					targetParentNode.right = null;
				}else{
					return false;
				}
			}else if(targetNode.left != null && targetNode.right != null){
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
				
			}else{
				if(targetNode.left != null){
					if(targetParentNode != null){
						if (targetParentNode.left.value == value) {
							targetParentNode.left = targetNode.left;
						} else {
							targetParentNode.right = targetNode.left;
						}
					}else{
						root = targetNode.left;
					}
				}else{
					if(targetParentNode != null){
						if (targetParentNode.left.value == value) {
							targetParentNode.left = targetNode.right;

						} else {
							targetParentNode.right = targetNode.right;
						}
					}else{
						root = targetNode.right;
					}
				}
			
			}
		}
		return true;
	}
	/**
	 * 
	 * @param node
	 * @return 返回以node为根节点的最小节点值
	 */
	public int delRightTreeMin(Node_A node){
		Node_A target = node;
		
		while(target.left != null){
			target = target.left;
		}
		delete(target.value);
		
		return target.value;
	}

	public Node_A search(int value){
		if(root == null){
			return null;
		}else{
			return root.search(value);
		}
	}
	public Node_A searchParent(int value){
		if(root == null){
			return null;
		}else{
			return root.searchParent(value);
		}
	}
}
class Node_A {
	int value;
	Node_A left;
	Node_A right;
	
	public Node_A(int value){
		this.value = value;
	}
	

	/**
	 * 查找要删除结点的父节点
	 * @param value
	 * @return
	 */
	public Node_A searchParent(int value){
		if((this.left != null && this.left.value == value) ||
				(this.right != null && this.right.value == value)){
			return this;
		}else{
			if((this.left != null && value < this.value)){
				return this.left.searchParent(value);
			}else if(this.right != null && value >= this.value){
				return this.right.searchParent(value);
			}else{
				return null;
			}
		}
	}
	
	/**
	 * 查找需要删除的结点
	 * @param value
	 * @return
	 */
	public Node_A search(int value){
		if(value == this.value){
			return this;
		}else if(value < this.value){
			if(this.left == null){
				return null;
			}
			return this.left.search(value);
		}else{
			if(this.right == null){
				return null;
			}
			return this.right.search(value);
		}
	}
	/**
	 * 添加结点
	 * @param node
	 */
	public void add(Node_A node){
		if(node == null){
			return;
		}
		
		if(node.value < this.value){
			if(this.left == null){
				this.left = node;
			}else{
				this.left.add(node);
			}
		}else{
			if(this.right == null){
				this.right = node;
			}else{
				this.right.add(node);
			}
		}
		
		if(rightHeight() - leftHeight() > 1){
			if(right != null && right.leftHeight() > right.rightHeight()){
				right.rightRotate();
				leftRotate();
			}else{
				leftRotate();
			}
			return;
		}
		if(leftHeight() - rightHeight() > 1){
			if(left != null && left.rightHeight() > left.leftHeight()){
				left.leftRotate();
				rightRotate();
			}else{
				rightRotate();
			}
		}
	}
	/**
	 * 中序遍历
	 */
	public void infixOrder(){
		if(this.left != null){
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null){
			this.right.infixOrder();
		}
	}
	@Override
	public String toString() {
		return "Node_A [value=" + value + "]";
	}
	//放回当前节点高度
	public int height(){
		return Math.max(left == null? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}
	//返回左子树的高度
	public int leftHeight(){
		if(left == null){
			return 0; 
		}
		return left.height();
	}
	//返回右子树的高度
	public int rightHeight(){
		if(right == null){
			return 0;
		}
		return right.height();
	}
	/**
	 * 左旋转
	 */
	private void leftRotate(){
		Node_A newNode = new Node_A(value);
		
		newNode.left = left;
		
		newNode.right = right.left;
		
		value = right.value;
		
		right = right.right;
		
		left = newNode;
	}
	/**
	 * 右旋转
	 */
	private void rightRotate(){
		Node_A newNode = new Node_A(value);
		
		newNode.right = right;
		
		newNode.left = left.right;
		
		value = left.value;
		
		left = left.left;
		
		right = newNode;
	}
}