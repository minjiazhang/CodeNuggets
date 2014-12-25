import java.util.LinkedList;
import java.util.List;


public class UniqueBinarySearch {
    public List<TreeNode> generateTrees(int n) {

        return helperGenTrees(1, n);
    }
List<TreeNode> helperGenTrees(int start, int end) {
     List<TreeNode> res = new LinkedList<TreeNode>();
     if (start > end) {
         res.add(null);
         System.out.println(res.size());
         return res;
     }
     if (start == end) {
         res.add(new TreeNode(start));
         return res;
     }
     for (int i = start; i <= end; i++) {
         List<TreeNode> lefts = helperGenTrees(start, i - 1); //Be careful about the boundary...it has to be i - 1, not i. Correspondingly, you add if (start > end) at the beginning.
         List<TreeNode> rights = helperGenTrees(i + 1, end);
       
        //  if (lefts.size() == 0) {            
        //       for (TreeNode right : rights) {
        //           TreeNode root = new TreeNode(i);
        //           root.right = right;
        //           res.add(root);
        //       }
        //       return res;
        //  }
        //  if (rights.size() == 0) {            
        //       for (TreeNode left: lefts) {
        //           TreeNode root = new TreeNode(i);
        //           root.left= left;
        //           res.add(root);
        //       }
        //       return res;
        //  }
         for (TreeNode left : lefts) { //What if lefts is null?
              for (TreeNode right : rights) {
                   TreeNode root = new TreeNode(i);
                   root.left = left;
                   root.right = right;
                   res.add(root);
              }
         }
     }
     return res;
}

	public static void main(String[] args) {
		UniqueBinarySearch s = new UniqueBinarySearch();
		s.generateTrees(0);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}
