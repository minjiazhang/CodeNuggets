import java.util.Stack;


public class EvalRPN {
    public int evalRPN(String[] tokens) {
        
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<String> rpnStack = new Stack<String>();
        String op1;
        String op2;
        String res;
        Integer i1;
        Integer i2;
        Integer i3 = Integer.valueOf(0);
        for (String token : tokens) { //Can I use this form to iterate a string array? Yes, after Java 5, this syntax is supported.
            if (isValidOperator(token)) {
                 op1 = rpnStack.pop();
                 op2 = rpnStack.pop(); //Might need to check invalid RPN? peek()?
                 i1 = Integer.parseInt(op1);
                 i2 = Integer.parseInt(op2);
                 
                 switch (token) {
                     case "+" :
                                     i3 = i2 + i1; //convert op1 and op2 to numbers.
                                     break;
                     case "-" :
                                     i3 = i2 - i1; //convert op1 and op2 to numbers.
                                     break;
                     case "*" :
                                     i3 = i2 * i1; //convert op1 and op2 to numbers.
                                     break;
                     case "/" :
                                     i3 = i2 / i1; //convert op1 and op2 to numbers.
                                     break;
                     default:
                                     break;
                 }
	              res = i3.toString();
	              rpnStack.push(res);
            } else if (isValidInteger(token)) {
            	rpnStack.push(token);
            } else {
                   return 0;
            }
        }
        return Integer.parseInt(rpnStack.pop());
    }
    
    boolean isValidOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    boolean isValidInteger(String token) {
        int num;
        try {
            num = Integer.parseInt(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
