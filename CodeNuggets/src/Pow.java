
public class Pow {
    public double pow(double x, int n) {
        
        if (eqDouble(x, 0.0) && n < 0) {
            return 0;
        }
        
        double result = 1.0;
        
        boolean isExpPositive = true;
        
        if (n < 0) {
            isExpPositive = false;
            n = -n;
        }
        
        result = powUnsignedExp(x, n);
        
        // for (int i = 0; i < n; i++) {
        //     result *= x;
        // }
        
        if (!isExpPositive) {
            result = 1 / result;
        }
        
        return result;
    }
    
    boolean eqDouble(double x, double y) {
        if (x - y <= 0.00001 && y - x <= 0.00001) {
            return true;
        }
        return false;
    }
    
    double powUnsignedExp(double base, int exp) {
    	
    	System.out.println(" exp: " + exp);
        
        if (exp == 0) {
            return 1;
        } 
        
        if (exp == 1) {
            return base;
        }
        
        double result = powUnsignedExp(base, exp / 2);
        result *= result;
        
        if (exp % 2 == 1) {
            result = result * base;
        }
        
        return result;
    }
}
