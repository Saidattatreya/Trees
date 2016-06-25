package com.alg.top20.treeproblems;
import java.util.*;
public class TreeTraversals {
	
	//do not invoke printLevelOrderRec from here, this is just an attempt to keep all the
	//tree traversals at one place. It needs height which is available given only in the main class
	public void printGivenLevel(TreeNode curr , int level)
	{
		if (curr == null) return;
		if (level == 1) 
			System.out.println(curr.data +" ");
		else{
			printGivenLevel(curr.left, level-1);
			printGivenLevel(curr.right, level-1);
		}
	}
	
	public void printLevelOrderRec(TreeNode curr)
	{
		//int height = TreeHeight.getHeight(bt.getroot());
		int height = 0;
		for(int i = 1 ; i<= height; ++i)
			printGivenLevel(curr, i);
	}
	
	//Print method to print levels in line by line.
	
	public void printlevelOrderLineByLineRec(TreeNode curr)
	{
		//int height = TreeHeight.getHeight(bt.getroot());
		int height = 0;
		for(int i = 1 ; i<= height; ++i)
		{
			printGivenLevel(curr, i);
			System.out.println();
		}
		
	}
	
	
	public static void printlevelOrderIter(TreeNode curr){
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(curr);
		
		while(!q.isEmpty())
		{
			TreeNode temp = q.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
				
		}
	}
		
	public static void printInOrderRec(TreeNode curr)
	{
	
		if(curr == null) return;
		printInOrderRec(curr.left);
		System.out.print(curr.data+" ");
		printInOrderRec(curr.right);
		
	}
	
	public static void printInOrderIter(TreeNode curr)
	{
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(true)
		{
			while(curr != null)
			{
				st.push(curr);
				curr = curr.left;
			}
			if(st.empty()) break;
			curr = st.pop();
			System.out.print(curr.data+" ");
			
			curr = curr.right;
		}
	}
	
	public static void printPreOrderRec(TreeNode curr)
	{
		if(curr == null ) return;
		System.out.print(curr.data+" ");
		printPreOrderRec(curr.left);
		printPreOrderRec(curr.right);
	}
	
	public static void printPreOrderIter(TreeNode curr){
	
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(true)
		{
			while(curr != null)
			{
				System.out.print(curr.data+" ");
				st.push(curr);
				curr = curr.left;
			}
			if(st.isEmpty()) break;
			curr = st.pop().right;
		}
	}
	
	public static void printPostOrderIter(TreeNode curr)
	{
		Stack<Entry> st = new Stack<Entry>();
		
		while(true)
		{
			while(curr != null)
			{
				st.push(new Entry(curr));
				curr = curr.left;
			}
			if(st.isEmpty()) break;
			
			Entry temp = st.peek();
			if(temp.isSecond == true)
			{
				System.out.print(temp.treeNodePtr.data+" ");
				st.pop();
				curr = null;
			}else{
				//System.out.print(temp.treeNodePtr.data+" ");
				temp.isSecond = true;
				curr = temp.treeNodePtr.right;
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
}
	
	
