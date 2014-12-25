
public class CountAndSay {
    public String countAndSay(int n) {
        
        if (n <= 0) {
            return ""; //defensive
        }
        
        if (n == 1) {
            return "1";
        }
        
        String prevStr = countAndSay(n - 1);
    	System.out.println(" prevStr: " + (n-1) + " str:" + prevStr);

        int len = prevStr.length();
        
        if (len == 1) {
            return "1" + prevStr;
        }
        
        StringBuilder nStr = new StringBuilder();
        int count = 1;
        char cur = ' ';
        for (int i = 1; i < len; ) {
            while (prevStr.charAt(i) == prevStr.charAt(i - 1)) {
                i++;
                count++;
                if (i == len) {
                	break;
                }
            }
            nStr.append(int2String(count));
            nStr.append(prevStr.charAt(i - 1));
            count = 1;
            i++;
        }
        
        System.out.println(" before last: " + n + " str:" + nStr.toString());
        
//        nStr.append(int2String(count));
//        nStr.append(prevStr.charAt(len - 1));
        
        return nStr.toString();
    }
    
    String int2String(int n) {
        return Character.toString((char)(n + '0'));
    }
}
