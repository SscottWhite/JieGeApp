package com.ncstudy.control;

class TreeNode1 {
	char data;
	TreeNode1 lchild;								// 左子结点指针
	TreeNode1 rchild;								// 右子结点指针

	public TreeNode1(char data) {
		this.data = data;
	}
}

public class TreeInvert {
	// 将二叉树的顺序存储变为链式存储
	public static TreeNode1 buildTree(char[] arr, int index) {
		TreeNode1 root = null;
		if (index < arr.length) {
			if (arr[index] == '#') {
				return null;
			}
			root = new TreeNode1(arr[index]);
			root.lchild = buildTree(arr, 2 * index + 1);
			root.rchild = buildTree(arr, 2 * index + 2);
		}
		return root;
	}

	// 先序遍历
	public static void preOrderTraverse(TreeNode1 T) {
		if (T != null) {
			System.out.print(T.data);
			preOrderTraverse(T.lchild);
			preOrderTraverse(T.rchild);
		}
	}

	// 中序遍历
	public static void inOrderTraverse(TreeNode1 T) {
		if (T != null) {
			inOrderTraverse(T.lchild);
			System.out.print(T.data);
			inOrderTraverse(T.rchild);
		}
	}

	// 后序遍历
	public static void postOrderTraverse(TreeNode1 T) {
		if (T != null) {
			postOrderTraverse(T.lchild);
			postOrderTraverse(T.rchild);
			System.out.print(T.data);
		}
	}

	public static void main(String[] args) {
		char[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', '#', '#', 'H', '#', '#', 'I' };
		TreeNode1 T = buildTree(arr, 0);

		System.out.print("先序遍历-->");
		preOrderTraverse(T);
		System.out.println();

		System.out.print("中序遍历-->");
		inOrderTraverse(T);
		System.out.println();

		System.out.print("后序遍历-->");
		postOrderTraverse(T);
		System.out.println();
	}
}
