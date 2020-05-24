package com.tree;
/**
 * 排序二叉树
 * @author 骄傲的大树
 *
 */
public class BinarySortTree {
	
	private Node_Sort root;
	 
	public static void main(String[] args) {
		int[] arr = {12,5,3,88,74,62,122,55,7,6,45};
		BinarySortTree sortTree = new BinarySortTree(); 
		for(int i = 0; i < arr.length; i++){
			sortTree.add(new Node_Sort(arr[i]));
		}
		sortTree.infixOrder();
		
		System.out.println(sortTree.delete(12));
		System.out.println(sortTree.delete(122));
		System.out.println(sortTree.delete(13));
		System.out.println(sortTree.delete(62));
		sortTree.infixOrder();
	}
	
	public void add(Node_Sort node){
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
			Node_Sort targetNode = search(value);
			if(targetNode == null){
				return false;
			} 
			if(root.left == null && root.right == null){
				root = null;
			}
			Node_Sort targetParentNode = searchParent(value);
			
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
	public int delRightTreeMin(Node_Sort node){
		Node_Sort target = node;
		
		while(target.left != null){
			target = target.left;
		}
		delete(target.value);
		
		return target.value;
	}

	public Node_Sort search(int value){
		if(root == null){
			return null;
		}else{
			return root.search(value);
		}
	}
	public Node_Sort searchParent(int value){
		if(root == null){
			return null;
		}else{
			return root.searchParent(value);
		}
	}
}
class Node_Sort {
	int value;
	Node_Sort left;
	Node_Sort right;
	
	public Node_Sort(int value){
		this.value = value;
	}
	

	/**
	 * 查找要删除结点的父节点
	 * @param value
	 * @return
	 */
	public Node_Sort searchParent(int value){
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
	public Node_Sort search(int value){
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
	public void add(Node_Sort node){
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
		return "Node_Sort [value=" + value + "]";
	}
	
}