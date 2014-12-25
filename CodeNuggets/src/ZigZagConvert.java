
public class ZigZagConvert {
    public String convert(String s, int nRows) {
        
        if (s == null || s.length() == 0) {
            return null;
        }
        
        if (nRows == 1) {
            return s;
        }
        
        int strLen = s.length();
        int zigLen = nRows + nRows - 2; //? Can this be zero? When row is 1...
        int nZigCol = nRows - 1;
        int col = nZigCol * (strLen / zigLen + 1); //The first muliplier is the number of columns in a small zig
        
        char[][] zigzag = new char[nRows][col];
        int indexStr = 0;
        for (int i = 0; i < nRows - 1; i++) {
            for (int j = 0; j < nRows; j++) {
                if (indexStr < strLen) {
                    System.out.println(" zizag element" + " row:" + i * nZigCol + " col:" + j + " char:" + s.charAt(indexStr));
                    zigzag[j][i * nZigCol] = s.charAt(indexStr++);
                }
            }
            for (int k = 1; k < nRows - 1; k++) {
                if (indexStr < strLen) {
                    zigzag[nRows - k - 1][i * nZigCol + k] = s.charAt(indexStr++);
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < col; j++) {
                if (zigzag[i][j] != 0) {
                    res.append(zigzag[i][j]);
                }
            }
        }
        
        return res.toString(); 
    }
}
