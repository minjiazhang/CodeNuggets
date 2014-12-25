
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int head = 0;
        int tail = len - 1;
        
        boolean end = false;
        while (head < tail) { //iterate from head to tail
            if (A[head] == elem) { //should be removed/replaced.
                while (A[tail] == elem) {
                    tail--;
                    len--;//skip those idential elements;
                    if (head > tail) {
                        end = true;
                        break;
                    }
                }
                if (end) {
                    break;
                }
                A[head] = A[tail];
                len--;//replaced. 
            }
            head++;
        }
        return len;
    }
}
