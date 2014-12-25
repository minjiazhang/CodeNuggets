import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class ParenthesisString {
    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<String>();
        if (n == 0) {
            res.add("");
        } else {
            List<String> last = generateParenthesis(n - 1);
            for (String str : last) {
                int len = str.length();
                for (int i = 0; i < len; i++){
                    if (str.charAt(i) == '(') {
                        String s = insert(str, i);
                        res.add(s);
                    }
                }
                
                res.add("()" + str);
            }
        }
        
        return new LinkedList<String>(res);
    }
    
    String insert(String str, int index) {
        String left = str.substring(0, index + 1);
        String right = str.substring(index + 1, str.length());
        return left + "()" + right;
    }
}
