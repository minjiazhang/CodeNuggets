
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode cur = null;
        ListNode prevm = null, postn = null, nodem = null, noden= null;
        int iter;
        for (cur = head, iter = 0; cur != null; cur = cur.next, iter++) {
             if (iter == m - 1) { //What if m is 1? prevm = null? Once we added a dummy node, prevm canot not be null.
                  prevm = cur;
             }
             if (iter == m) {
                  nodem = cur;
             }
             if (iter == n) { 
                  noden = cur; //noden seems to be useless? No, it is useful, nodem.next has to point to postn.
             }
             if (iter == n+1) {
                  postn = cur;
                  break;
             }
        }
        
        ListNode next = null, prev = null;
        //reverse(m, n)
        for (cur = nodem; cur != postn;) {
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
        }
        
        prevm.next = noden;
        nodem.next = postn;
        
        return dummy.next;
    }
}
