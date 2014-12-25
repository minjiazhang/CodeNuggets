import java.util.Arrays;


public class threeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;// The question says we can assume the input has one solution.
        }
        
        // long closest = (long)Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            
            while (left < right) { //Can you predict what would be in the while loop?
                int threeSum = num[i] + num[left] + num[right];
           	 	System.out.println(" threeSum:" + threeSum);
                if (threeSum < target) {
                    left++;
               	 	System.out.println(" left:" + left);
                } else if (threeSum > target) {
                    right--;
                } else {
                     return target;
                }
                if (Math.abs(threeSum - target) < minDist) {
                     minDist = Math.abs(threeSum - target);
                     closest  = threeSum;
                	 System.out.println(" closest:" + closest);

                }
               // should have a condition to decide to increase the left pointer or decrease the right pointer. This is the key...
            }
        }

        return closest;
    }
}
