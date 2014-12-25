
public class SearchRotatedArray {
	   public boolean search(int[] A, int target) {
	        int len = A.length - 1;
	        return search(A, 0, len, target);
	    }
	    
	    boolean search(int[] A, int low, int high, int target) {
	        
	        if (low > high) {
	            return false;
	        }
	        boolean result;
	        //First compute the middle.
	        int middle = low + (high - low) / 2; //Avoid overflow. This is merely a piece of knowledge, if you see and understand why one should do this, you know this is a better choice (being professional.)
	        
	        System.out.println(" middle: " + middle + " low:" + low + " high:" + high);
	        
	        if (A[middle] == target) {
	            return true;
	        } else if (A[middle] < target) {
	            
	            if (A[high] < target && A[middle] <= A[high]) { 
	                //target is larger than the righ most sentiel, try the other side.
	                result = search(A, low, middle - 1, target); 
	            } else {
	                result = search(A, middle + 1, high, target);
	            }
	        } else {
	            if (target < A[low] && A[low] <= A[middle]) {
	                result = search(A, middle + 1, high, target);
	            } else {
	                result = search(A, low, middle - 1, target);
	            }
	        }
	        
	        if (result) {
	            return true;
	        } else {
	            return false;
	        }
	    }
}
