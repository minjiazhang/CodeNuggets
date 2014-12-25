import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BreadFirstSearchII {
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
             ArrayList<Integer> level = new ArrayList<Integer>();
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                 TreeNode cur = queue.poll();
                 level.add(cur.val);
                 if (cur.left != null) {
                      queue.offer(cur.left);
                 }
                 if (cur.right != null) {
                      queue.offer(cur.right);
                 }
             }
             res.add(0, level); //always add to the first
        }
        return res;
    }
}
