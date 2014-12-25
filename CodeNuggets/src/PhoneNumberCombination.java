import java.util.LinkedList;
import java.util.List;


public class PhoneNumberCombination {
    public List<String> letterCombinations(String digits) {
// If the current digit is past the last digit
//     Print the word because you’re at the end
// Else
//     For each of the three digits that can represent the current digit
//         Have the letter represent the current digit
//         Move to next digit and recurse
//         If the current digit is a 0 or a 1, return
        LinkedList<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        //Note that there are two digits that can respresent 4 letters.
        String[] d2l = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        StringBuilder str = new StringBuilder();
        recLC(res, digits, 0, str, d2l);
        
        return res;
    }
            
    void recLC(LinkedList<String> res,  String digits, int start, StringBuilder str, String[] d2l) {
        int len = digits.length();
        if (start == len) {
            res.add(str.toString());
            return;
        }
        
        char cur = digits.charAt(start);
        int curDigit = cur - '0';
        String possibleSet = d2l[curDigit];
        for (int i = 0; i < possibleSet.length(); i++) {
            str.append(digits.charAt(i));
            recLC(res, digits, start + 1, str, d2l);
            str.setLength(str.length() - 1);
        }
    }
}
