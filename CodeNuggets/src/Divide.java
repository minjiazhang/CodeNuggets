
public class Divide {
    public int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return 0;
        }
        
        if (divisor == 1) {
            return dividend;
        }

        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        
        long num1 = Math.abs((long)dividend);
		System.out.println(" dividend 1:" + (num1));

		long num2 = Math.abs((long)divisor);
        
        // int count = 0;
        int result = 0; 
        for (int i = 63; i >= 0; i--) {
            result = result << 1;
    		System.out.println(" num1:" + (num1 >> i));

            if (num1 >> i >= num2) {
                result += 1;
                num1 -= num2 << i;
            }
        }
        
        // while ( diff >= num2) { //Should be larger or equal.
        //   diff -= num2;  //Could not quite understand, but NC uses shift?
        //   count++;
        // }
        // reminder = diff;
        // design + or -.
        // +/- count (should this be the return value?) 
        return isNeg? -result : result;
    }
}
