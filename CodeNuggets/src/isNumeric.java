
public class isNumeric {
    public boolean isNumber(String s) {
        
        if (s == null || s.length() == 0) {
            return false;
        }
        
        int len = s.length();
        
        int index = 0;
        
        while (s.charAt(index) == ' ') {
            index++;
        }
        
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        } else if (!(isDigit(s.charAt(index)))) {
            return false;
        }
        
        boolean numeric = true;
        System.out.println(" isNum : " + numeric);

        char cur;
        index = scanDigits(s, index);
        System.out.println(" index : " + index);

        if (index < len) {
            cur = s.charAt(index);
            if (cur == '.') {
                index++;
                if (index < len) {
	                index = scanDigits(s, index);
	                if (index < len) {
		                if (s.charAt(index) == 'e' || s.charAt(index) == 'E') {
		                    numeric = isExp(s, index);
		                }
	                } else {
	                	return numeric;
	                }
                } else {
                	return numeric;
                }
            } else if (cur == 'e' || cur == 'E') {
                numeric = isExp(s, index);
            } else if (cur == ' ') {
                System.out.println(" len : " + len + " isNum : " + numeric + " index:" + index);
            	//What if there are spaces following the numeric?
            	while (index + 1 < len && s.charAt(index + 1) == ' ') {
                    index++;
                }
                System.out.println(" len : " + len + " isNum : " + numeric + " index:" + index);
            } else {
            	numeric = false;
            }
            
            index++;
        }
        
        return numeric && index == len;
    }
    
    
    boolean isExp(String s, int index) {
        int len = s.length();
        if (s.charAt(index) != 'e' && s.charAt(index) != 'E') {
            return false;
        }
        index++;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }
        
        if (index == len - 1) {
            return false; //e is the end character
        }
        
        index = scanDigits(s, index);
        return index == len - 1 ? true : false;
    }
    
    boolean isDigit(char ch) {
        if (ch >= '0' &&  ch <= '9') {
            return true;
        }
        return false;
    }
    
    int scanDigits(String s, int index) {
        int len = s.length();
        for (int i = index; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                index++;
            } else {
                break;
            }
        }
        return index;
    }
    
    boolean isAlphabetic(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }
}
