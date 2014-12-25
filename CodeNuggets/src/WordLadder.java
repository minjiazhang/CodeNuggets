import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class WordLadder {
public int ladderLength(String start, String end, Set<String> dict) {
        
        //Special cases
        if (start == null || end == null) {
            return 0;
        }
        
        if (start.length() != end.length()) {
            //Different length -> impossible to transform.
            return 0;
        }
        
        //We might need two stacks to track how many steps we need to get the transformation in a lock step way (breadth first exploration.)
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        
        stack1.push(start);
        
        //use a hash set to redeuce redundance. For those that have already been proceesed (i.e., in a stack), we don't push them to stack.
        HashSet<String> genStrSet = new HashSet<String>();
        int len = start.length();
        boolean isFound = false;
        int iter = 0;        //Track how many steps to get the transformation. 
        String cur = "";
        //Each time generate a new word, push it onto stack.
        while (true) {
            //Each time pop up a generated word, check it from left to right and change the first one that are different from end.Throw the newly generated word back to the stack. 
            //Alternate between two stacks. Process all elements in one stack and then alternate to handle the other one. 
            if (iter % 2 == 0) {
                if (stack1.isEmpty()) {
                    return 0; //stack1 is empty in its turn yet we haven't found a valid transformation. 
                }
                while(!stack1.isEmpty()) {
                    cur = stack1.pop();
                    System.out.println(" cur string: " + cur + ", iter: " + iter);
                    for (int i = 0; i < len; i++) {
                        if (cur.charAt(i) != end.charAt(i)) {
                            String newStr = replaceCharAtIndex(cur, end, i);
                            System.out.println(" created new string: " + newStr + " iter: " + iter);
                            if (newStr.equals(end)) {
                                return iter+2; //Guarantee to be the smallest step because we did width exploration. Return sequence length instead of times of transformation. 
                            } else {
                                if (!genStrSet.contains(newStr)) {
                                    genStrSet.add(newStr);
                                    if (dict.contains(newStr)) {
                                    	stack2.push(newStr);
                                    }
                                } else {
                                    //do nothing
                                }
                            }
                        }
                    }
                }
                //? If no more string needs to be handled, there is no valid transformation.
            } else {
                if (stack2.isEmpty()) {
                    return 0; //stack2 is empty in its turn yet we haven't found a valid transformation. 
                }
                while(!stack2.isEmpty()) {
                    cur = stack2.pop();
                    System.out.println(" cur string: " + cur + " iter: " + iter);
                    for (int i = 0; i < len; i++) {
                        if (cur.charAt(i) != end.charAt(i)) {
                            String newStr = replaceCharAtIndex(cur, end, i);
                            System.out.println(" created new string: " + newStr + " iter: " + iter);
                            if (newStr.equals(end)) {
                                return iter+2; 
                            } else {
                                if (!genStrSet.contains(newStr)) {
                                    genStrSet.add(newStr);
                                    if (dict.contains(newStr)) {
                                    	stack1.push(newStr);
                                    }
                                } else {
                                    //do nothing
                                }
                            }
                        }
                    }
                }
            }
            iter++;
        }
        
    }
    
    String replaceCharAtIndex(String start, String end, int i) {
        int len = start.length(); //FIXME: you somehow assume that the word is at least 3 letters long. 
        //What if the length is 1.
        if (len == 1) {
            return end;
        }
        //What if i is the first character or the last character? 
//        if (i == 0) {
//            return end.substring(i, i+1) + start.substring(i+1, len);
//        } else if (i == len - 1) {
//            return start.substring(0, i) + end.substring(i, i+1);
//        } else {
            return start.substring(0, i) + end.substring(i, i+1) + start.substring(i+1, len);
//        }
    }
}
