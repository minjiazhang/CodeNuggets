import java.util.LinkedList;
import java.util.List;


public class Permutation {
    public List<List<Integer>> permute(int[] num) {
        //?Handle num is null
        if (num == null) {
            return null;
        }
        List<List<Integer>> perm = new LinkedList<List<Integer>>();
        int len = num.length;
        boolean[] isUsed = new boolean[len];
        LinkedList<Integer> res = new LinkedList<Integer>();
        permute(perm, num, isUsed, res);
        System.out.println(" final:" + perm);
        return perm;
    }
    
    void permute(List<List<Integer>> perm, int[] num, boolean[] isUsed, LinkedList<Integer> res) {
        int len = num.length;
        if (res.size() >= len) {
            perm.add(new LinkedList<Integer>(res));
            System.out.println(" add new entry:" + res);
            return; 
        }
        
        for (int i = 0; i < len; i++) {
            if (isUsed[i]) {
                continue;
            }
            res.add(num[i]);
            System.out.println(" add new number:" + res);
            isUsed[i] = true;
            permute(perm, num, isUsed, res);
            isUsed[i] = false;
            System.out.println(" remove last number:" + res);
            res.removeLast();
            System.out.println(" current perm:" + perm);
        }
    }
}
