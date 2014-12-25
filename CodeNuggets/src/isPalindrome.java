
public class isPalindrome {
    public boolean isPalindrome(int x) {
        int length = 0;
        int temp = x;
        while (temp/10 != 0) {
            temp = temp/10;
            length++;
        }
        if (temp % 10 != 0) {
            length++;
        }
        //get the length.
		System.out.println(" length:" + length);

        int left = 0;
        int right = 0;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            temp = x;
            //get right
            for (int t = 0; t < i; t++) {
                temp = temp/10;
            }
            right = temp % 10;
            
            temp = x;
            //get left
            for (int q = 0; q < j; q++) {
                temp = temp/10;
            }
            left = temp % 10;
            
    		System.out.println(i + " :" + j + " : " + temp);
    		System.out.println(left + " :" + right + " : " + temp);
            
            if (right != left) {
                return false;
            }
        }
        return true; 
    }
}
