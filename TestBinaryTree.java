package com.alg.top20.treeproblems;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class TestBinaryTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void add(Integer element) {
		TreeNode curr = root;
		if (curr == null) {
			root = new TreeNode(element);
			return;
		}
		while (true) {
			if (Math.random() < 0.5) {
				if (curr.left == null) {
					curr.left = new TreeNode(element);
					break;
				} else {
					curr = curr.left;
				}

			} else {
				if (curr.right == null) {
					curr.right = new TreeNode(element);
					break;
				} else {
					curr = curr.right;
				}

			}
		}
	}

	public void display() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		System.out.print(root.data + " ");
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			if (temp.left != null) {
				q.add(temp.left);
				System.out.print(temp.left.data + " ");
			} else {
				System.out.print("null ");
			}
			if (temp.right != null) {
				q.add(temp.right);
				System.out.print(temp.right.data + " ");

			} else {
				System.out.print("null ");
			}
		}
		System.out.println();
	}

	public void displayRecursive() {
		int height = TreeHeight.getHeight(root);

		for (int i = 1; i <= height; ++i)
			displayGivenLevel(root, i);

	}

	public void displayGivenLevel(TreeNode curr, Integer level) {
		if (curr == null)
			return;
		if (level == 1)
			System.out.print(curr.data + "  ");
		else {
			displayGivenLevel(curr.left, level - 1);
			displayGivenLevel(curr.right, level - 1);
		}

	}

	public void printlevelOrderLineByLine() {
		int height = TreeHeight.getHeight(root);

		for (int i = 1; i <= height; ++i) {
			displayGivenLevel(root, i);
			System.out.println();

		}
	}

	public void printLevelOrder() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data + "  ");

			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	public void printLevelOrderLineByLineIter() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0) break;
			while (nodeCount > 0) {
				TreeNode temp = q.poll();
				System.out.print(temp.data + "  ");

				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				--nodeCount;
			}
			System.out.println();
		}
	}

	public int getHeight(TreeNode curr) {
		if (curr == null)
			return 0;
		else {
			int lheight = getHeight(curr.left);
			int rheight = getHeight(curr.right);
			if (lheight > rheight)
				return lheight + 1;
			else
				return rheight + 1;
		}
	}

	public void printInOrderRecursive(TreeNode curr) {
		if (curr == null)
			return;
		printInOrderRecursive(curr.left);
		System.out.print(curr.data + " ");
		printInOrderRecursive(curr.right);
	}

	public void printPreOrderRecursive(TreeNode curr) {
		if (curr == null)
			return;
		System.out.print(curr.data + " ");
		printPreOrderRecursive(curr.left);
		printPreOrderRecursive(curr.right);
	}

	public void printPostOrderRecursive(TreeNode curr) {
		if (curr == null)
			return;

		printPostOrderRecursive(curr.left);
		printPostOrderRecursive(curr.right);
		System.out.print(curr.data + " ");
	}

	public void randomBST(int n) {
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			add(r.nextInt(50) + 1);
		}

	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);

		TestBinaryTree bt = new TestBinaryTree();
		bt.randomBST(size);
		bt.display();
		// bt.displayRecursive();
		// System.out.println();
		System.out.println("\n Size of the tree " + TreeSize.treeSize2(bt.getRoot()));
		System.out.println("\n Height of the tree " + bt.getHeight(bt.getRoot()));

		System.out.println("\n Printing levels in one line recursive");
		bt.displayRecursive();

		System.out.println("\n Printing levels in one line iterative");
		bt.printLevelOrder();

		System.out.println("\n Printing levels in line by line recursive");
		bt.printlevelOrderLineByLine();
		
		System.out.println("\n Printing levels in line by line iterative");
		bt.printLevelOrderLineByLineIter();

		System.out.println("\n In order  recursive output :");
		bt.printInOrderRecursive(bt.getRoot());

		System.out.println("\n In order iterative output :");
		TreeTraversals.printInOrderIter(bt.getRoot());

		System.out.println("\n Pre order recursive output :");
		bt.printPreOrderRecursive(bt.getRoot());

		System.out.println("\n Pre order iterative output :");
		TreeTraversals.printPreOrderIter(bt.getRoot());

		System.out.println("\n Post order Recursive output :");
		bt.printPostOrderRecursive(bt.getRoot());

		System.out.println("\n Post order iterative output:");
		TreeTraversals.printPostOrderIter(bt.getRoot());
	}

}
