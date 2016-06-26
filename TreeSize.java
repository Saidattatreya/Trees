
import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	public static int treeSize1(TreeNode curr)
	{
		if (curr == null) return 0;
		if (curr.left == null && curr.right == null) return 1;
		int ls = treeSize1(curr.left);
		int rs = treeSize1(curr.right);
		return ls+rs+1;
	}
	
	public static int treeSize2(TreeNode curr)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(curr);
		int size = 0;
		
		while(!q.isEmpty())
		{
			TreeNode temp = q.remove();
			++size;
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
			
		}
		return size;
	}
}
