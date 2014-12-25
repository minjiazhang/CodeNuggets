
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        
        char cur;
        int count = 0; 
        boolean found = false;
        int i = len - 1;
        for (; i >= 0; i--) {
            cur = s.charAt(i);
            if (!found && cur == ' ') {
                continue;
            }
            
            if (!found) {
                found = true;
            }
            
            if (found) {
                if (cur != ' ') {
                    count++;
                    continue;
                }
                
                if (cur == ' ') {
                    break;
                }
            }
        }
        
        if (i < 0) {
            if (found) {
                if (s.charAt(0) != ' ') {
                    return 0;
                } else {
                    return count;
                }   
            } else {
                return 0;
            }
        } else {
            return count;
        }
    }
}
