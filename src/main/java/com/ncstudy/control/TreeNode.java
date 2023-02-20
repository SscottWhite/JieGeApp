package com.ncstudy.control;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
	TreeNode(){}
	
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);		
		root.left = right;
		root.right = left;		
		return root;
	}
	
	public TreeNode addNode(int[] arr,int index) {
		TreeNode treeNode = null;
		if(index < arr.length) {
			if(arr[index] == -1) {
				return null;
			}
			treeNode = new TreeNode(arr[index]);
			treeNode.left = addNode(arr,2*index + 1);
			treeNode.right = addNode(arr,2*index + 2);
		}
		return treeNode;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
	}
}
