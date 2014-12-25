
public class UniquePathWithObstacle {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid == null) {
            return 0;
        }
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] calPaths = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                calPaths[i][j] = -1;
            }
        }
        int paths = helper(obstacleGrid, row, col, 0, 0, calPaths);
        return paths;
    }
    
    int helper(int[][] obstacleGrid, int m, int n, int x, int y, int[][] calPaths) {
    
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length; 
        
        if (calPaths[x][y] != -1) {
            return calPaths[x][y];
        }
        
        if (x == row - 1) {
            for (int i = y; i < col; i++) {
                if (obstacleGrid[x][i] == 1) {
                    calPaths[x][y] = 0;
                    return 0;
                }
            }
            calPaths[x][y] = 1;
            return 1;
        }
        
        if (y == col - 1) {
            for (int i = x; i < row; i++) {
                if (obstacleGrid[i][y] == 1) {
                    calPaths[x][y] =0;
                    return 0;
                }
            }
            calPaths[x][y] = 1;
            return 1;
        }
        
        if (obstacleGrid[x][y] == 1) { //Handle boundaries
            calPaths[x][y] = 0;
            return 0;
        }
    
        calPaths[x][y] = helper(obstacleGrid, m - 1, n, x + 1, y, calPaths) + helper(obstacleGrid, m, n - 1, x, y + 1, calPaths);
        return calPaths[x][y];
    }
}
