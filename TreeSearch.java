
import java.util.Queue;
import java.util.LinkedList;
public class TreeSearch {

	public static boolean treeSearch1(TreeNode curr , Integer key)
	{
		if (curr== null)
			return false;
		if (key.equals(curr.data))
			return true;
		else if (curr.left != null)
			return treeSearch1(curr.left , key);
		else if (curr.right != null)
			return treeSearch1(curr.right, key);
		else;
			return false;		
		
	}
	
	public static boolean treeSearch2(TreeNode curr , Integer key)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(curr);
		while(!q.isEmpty())
		{
			TreeNode temp = q.remove();
			if (key.equals(temp.data)) return true;
			if (temp.left != null) q.add(temp.left);
			if (temp.right != null) q.add(temp.right);
			
		}
		
		return false;
	}
}
