import java.util.LinkedList;
import java.util.List;


public class Subset {
    public List<List<Integer>> subsets(int[] S) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> set = new LinkedList<Integer>();
        
        if (S == null) {
            return null;
        }
        
        int len = S.length;
        recSubsets(S, res, 0, len, set);
        //?Handle empty set.
        LinkedList<Integer> emptySet = new LinkedList<Integer>();
        res.add(emptySet);
        return res;
    }
    
    void recSubsets(int[] S, LinkedList<List<Integer>> res, int start, int len, LinkedList<Integer> set) {
        //?Handle base.
        if (start == len) {
            return;
        }
        
        for (int i = start; i < len; i++) {
            set.add(S[i]);
            res.add(new LinkedList<Integer>(set));
            recSubsets(S, res, i + 1, len, set);
            set.removeLast();
        }
    }
}
