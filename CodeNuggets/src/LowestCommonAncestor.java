import java.util.ArrayList;


public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
        
        getPathRoot(root, path1, A);
        getPathRoot(root, path2, B);
        
        int i;
        for (i = 1; i < path1.size() && i < path2.size(); i++) {
             if (path1.get(i) != path2.get(i)) {
                 return path1.get(i - 1);
             }    
        }
        if (i == path1.size()) {
             return path1.get(i - 1);
        } else {
             return path2.get(i - 1);
        }
    }
    
    
    void getPathRoot(TreeNode root, ArrayList<TreeNode> path, TreeNode target) {
         if (root == null) {
             return;
         }
         path.add(root);
         if (root == target) {
             return;
         }
         getPathRoot(root.left, path, target);
         getPathRoot(root.right, path, target);
         path.remove(path.size() - 1);
    }
}
