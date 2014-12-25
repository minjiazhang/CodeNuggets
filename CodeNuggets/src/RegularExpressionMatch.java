
public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        //handle null and spcial cases.
        if (s == null && p == null) {
            return true;
        }
        
        if (s == null || p == null) {
            return false;
        }
        return match(s, 0, p, 0);
    }
    
    boolean match(String text, int textStart, String reg, int regStart) {
        int textLen = text.length();
        int regLen = reg.length();
        
        if (regLen == regStart) { //not *
            return textLen == textStart;
        }
        
        //peek the next character, if it is a *, try to match the star. 
        if (reg.charAt(regStart + 1) == '*') { //Make sure regStart + 1 does not exceed the array boundary.
            return matchstar(text, textStart, reg, regStart + 2, reg.charAt(regStart));
        }
        
        if (textStart < textLen && (reg.charAt(regStart) == '.' || reg.charAt(regStart) == text.charAt(textStart))) {
            return match(text, textStart + 1, reg, regStart + 1);
        }
        
        return true; 
    } 
    
    boolean matchstar(String text, int textStart, String reg, int regStart, char c) {
        int textLen = text.length();
        do {
            if (match(text, textStart, reg, regStart)) {
                return true;
            } //If failed, the above code is litterally performing a backtracking. 
        } while (textStart < textLen && (text.charAt(textStart++) == c || c == '.'));
        return false;
    }
}
