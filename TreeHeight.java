package com.alg.top20.treeproblems;

public class TreeHeight {

	public static int getHeight(TreeNode curr)
	{
		if (curr == null)
			return 0;
		int leftHeight = getHeight(curr.left);
		int rightHeight = getHeight(curr.right);
		
		if(leftHeight > rightHeight)
			return leftHeight+1;
		else
			return rightHeight+1;
	}
}
