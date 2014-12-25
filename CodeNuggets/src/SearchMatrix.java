
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        
        int i = 0;
        int j = row - 1;
        int mid = 0;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        int rowT = i;
        //Binary search row i
        i = 0; j = col - 1;
        while (i <= j) {
            mid = i + (j - i) / 2;
            int midVal = matrix[row][mid];
            if (target == midVal) {
                return true;
            } else if (target < midVal) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false; 
    }
}
