
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        
        if (A == null || B == null) {
            return 0;
        }
        
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKthTwoSortedArray(A, B, 0, 0, len / 2 + 1);
        } else {
            return (findKthTwoSortedArray(A, B, 0, 0, len / 2) + findKthTwoSortedArray(A, B, 0, 0, len / 2 + 1)) / 2;
        }
    }
    
    
    double findKthTwoSortedArray(int[] A, int[] B, int startA, int startB, int k) {
         int lenA = A.length;
         int lenB = B.length;
         if (startA >= lenA) { //I was right to first handle special case, but I should first handle more extreme case: when one is empty
            return B[startB + k - 1]; //Be careful, not B[k]. You need to consider startB; think the first smallest, which would make the boundary condition easier.
         }
         if (startB >= lenB) {
            return A[startA + k - 1];
         }
         
        if (k == 1) {
             if (A[startA] < B[startB]) {
                 return A[startA];
             } else {
                 return B[startB];
             }
        }
         
        int A_key = startA + k/2 - 1 >= lenA ? Integer.MAX_VALUE : A[startA + k/2 - 1];
        int B_key = startB + k/2 - 1 >= lenB ? Integer.MAX_VALUE : B[startB + k/2 - 1];
        
        if (A_key < B_key) {
             //discard k/2 in A
            return findKthTwoSortedArray(A, B, startA + k/2, startB, k/2);
        } else {
            return findKthTwoSortedArray(A, B, startA, startB + k/2, k/2);
        }
    }
}
