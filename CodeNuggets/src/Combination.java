import java.util.LinkedList;
import java.util.List;


public class Combination {
    public List<List<Integer>> combine(int n) {
        
        LinkedList<List<Integer>> comb = new LinkedList<List<Integer>>();
        LinkedList<Integer> res = new LinkedList<Integer>();
        //For each letter from the input starting position to end of input string
        recCombine(n, 0, comb, res);
        return comb;
    }
    
    void recCombine(int n, int start, LinkedList<List<Integer>> comb, LinkedList<Integer> res) {
        for (int i = start; i < n; i++) {
            res.add(i);
            comb.add(new LinkedList<Integer>(res));
            //recursively append letters after the the input start position.
            recCombine(n, i + 1, comb, res);
            res.removeLast();
        }
    }
}
