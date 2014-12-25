import java.util.LinkedList;
import java.util.Queue;


public class SurroundRegion {
    public void solve(char[][] board) {
        
        if (board == null || board.length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        if (col == 0) {
            return;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < row; i++) {
            enqueue(queue, board, i, 0);
            enqueue(queue, board, i, col - 1);
        }
        
        for (int i = 0; i < col; i++) {
            enqueue(queue, board, 0, i);
            enqueue(queue, board, row - 1, i);
        }
        
        while (!queue.isEmpty()) { //This is the way to iterating the queue while adding new elements.
           int cur = queue.poll();
           int rowIndex = cur / row;
           int colIndex = cur % row;
           board[row][col] = 'U';
           enqueue(queue, board,rowIndex - 1, colIndex);
           enqueue(queue, board,rowIndex + 1, colIndex);
           enqueue(queue, board,rowIndex, colIndex - 1);
           enqueue(queue, board,rowIndex, colIndex + 1);
        }
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
        	char cur = board[i][j];
            if (cur == 'O') {
               //Change O to X;
               board[i][j] = 'X';
            } else if (cur == 'U') {
               //Change U to O    
               board[i][j] = 'O';
            }
          }
        }
        
    }
    
    void enqueue(Queue queue, char[][] board, int x, int y) { //Most important; tricky
    	int row = board.length;
    	int col = board[0].length;
    	if (x >= 0 && x < row && y >=0 && y < col && board[x][y] == 'O') {
            
            queue.add(x * row + y);
        }
    }
}
