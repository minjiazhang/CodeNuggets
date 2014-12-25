
public class Multiplication {
    public String multiply(String num1, String num2) {
        
        if (num1 == null || num2 == null) {
            return null;
        }
        
        if (num1.length() == 0 || num2.length() == 0) {
            return null; //or ""? 
        }
        
        String rN1 = reverse(num1);
        String rN2 = reverse(num2);
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        //?First make it int[], later transfer it into char[]
        int[] result = new int[len1 + len2 + 1]; //? Is it enought
        int[] tempResult = new int[len1 + 1];
        int num1Digit;
        int num2Digit;
        int tempDigitMultiRes;
        int startPosRes = 0;
        int reminder = 0;
        int carry = 0;
        for (int i = 0; i < len2; i++) {
            num2Digit = char2Int(rN2.charAt(i));
            int j = 0;
            for (; j < len1; j++) {
                num1Digit = char2Int(rN1.charAt(j));
                tempDigitMultiRes = num1Digit * num2Digit;
                reminder = (tempDigitMultiRes + carry) % 10;
                carry = tempDigitMultiRes / 10; 
                tempResult[j] = reminder;
                System.out.println(" temp result: " + (j) + " reminder:" + reminder + " carry:" + carry);
            }
            tempResult[j] = carry;
            System.out.println(" temp result: " + (j) + " carry:" + carry);

            
            int sumCarry = 0;
            int sumReminder = 0; 
            int tempSum = 0;
            int k = 0;
            for (; k < len1 + 1; k++) { //< len1 + 1 because the carrier could make the intermediate result larger than len1.
                tempSum = result[k + startPosRes] + tempResult[k] + sumCarry;
                sumCarry = tempSum / 10;
                sumReminder = tempSum % 10;
                result[k + startPosRes] = sumReminder;
                System.out.println(" intermediate result: " + (k+startPosRes) + " sumReminder:" + sumReminder);
            }
            result[k + startPosRes] = sumCarry;
            
            System.out.println(" intermediate result: " + (k+startPosRes) + " sumCarry:" + sumCarry);
            
            startPosRes++;
            carry = 0;
        }
        
        int count = len1 + len2 + 1;
        for (int i = len1 + len2; i >= 0; i--) {
            if (result[i] == 0) {
                count--;
                continue;
            } else {
                break;
            }
        }
        
        System.out.println(" RESULT: count" + count);
        
        if (count == 0) {
            return "0";
        }
        
        char[] multiRes = new char[count]; //?assume count is not zero. Handle the case where one multiplier is 0.
        int resLen = count;
        for (int i = 0; i < resLen; i++, count--) {
            multiRes[i] = (char)(result[count - 1] + '0');
        }
        
        return new String(multiRes);
    }
    
    String reverse(String str) {
        char[] temp = str.toCharArray();
        int len = str.length();
        char cur;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            cur = temp[i];
            temp[i] = temp[j];
            temp[j] = cur;
        }
        
        return new String(temp);
    }
    
    int char2Int(char ch) {
        return ch - '0';
    }
}
