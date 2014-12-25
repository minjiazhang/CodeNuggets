import java.util.ArrayList;


public class PalindromePartition {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
     
    static final int isPal    = 1;
    static final int isNotPal = 2;
     
    public List<List<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> partition = new ArrayList<String>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        int len = s.length();
        int[][] rec = new int[len + 1][len + 1];
        helper(result, partition, rec, s, 0);
        return result;
    }
    
    void helper(ArrayList<ArrayList<String>> result, ArrayList<String> partition, int[][] rec, String s, int cutIndex) {

         int len = s.length();
         if (cutIndex == len) {
             result.add(new ArrayList<String>(partition));
             return;
         }
         for (int i = cutIndex + 1; i <= len; i++) {
             if (rec[cutIndex][i] == isPal) {
                   String cut = s.substring(cutIndex, i);
                   rec[cutIndex][i] = isPal;
                   partition.add(cut);
                   helper(result, partition, rec, s, i);
                   partition.remove(partition.size() - 1);
             } else if (rec[cutIndex][i] == isNotPal) {
                  //do nothing.
             } else {
                  String cut = s.substring(cutIndex, i);
                  boolean res = isPalindrome(cut);
                  if (res) {
                       rec[cutIndex][i] = isPal;
                       partition.add(cut);
                       helper(result, partition, rec, s, i);
                       partition.remove(partition.size() - 1);
                  } else {
                       rec[cutIndex][i] = isNotPal;
                  }
             }        
         }
    }
    
    boolean isPalindrome(String s) {
        int len = s.length();
        int low = 0;
        int high = len - 1;
        
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        
        return true;
    }
}
