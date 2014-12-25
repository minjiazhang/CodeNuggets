
public class LinkListPartition {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = null;
        ListNode lessTail = null;
        ListNode largerHead = null;
        ListNode cur = head;
        
        boolean foundLargerHead = false;
        boolean foundLessTail = false;
        
        //first find the lessTail and largerHead.
        while (cur != null) {
            if (cur.val >= x && !foundLargerHead) {
                largerHead = cur;
                foundLargerHead = true;
            } 
            
            if (cur.val < x && !foundLessTail) {
                lessTail = cur;
                newHead = cur;
                foundLessTail = true;
            }
            
            cur = cur.next;
        }
        
        if (lessTail == null) {
            newHead = largerHead; 
        }
        
        System.out.println(" lessTail:" + lessTail.val + " largerhead:" + largerHead.val);
        
        cur = head;
        while (cur != null) {
            // if (cur.val >= x) {
            //     // if (largerHead == null) {
            //     //     largerHead = cur;
            //     //     // foundLargerHead = true; //Once we found the larger head, any following nodes that are larger or equal to x can just append after the largerHead.
            //     // }
            //     //For other cases, they are automatically followed by the largerHead since we move those nodes that are smaller than x before largerHead (including adjust links.)
            // } else {
            //     // if (lessTail == null) {
            //     //     newHead = cur;
            //     //     lessTail = cur;
            //     //     lessTail.next = largerHead;
            //     // } else {
            //         lessTail.next = cur;
            //         cur.next = largerHead; 
            //         lessTail = cur; 
            //     // }
            // }
            
            
            if (cur.next == lessTail && lessTail != null) {
                cur.next = lessTail.next;
                lessTail.next = largerHead;
                System.out.println("set lessTail?");
            }
            
            ListNode temp = cur.next; //We might change cur.next in the following code. Therefore performing the backup. 
            if (cur.val < x && cur != lessTail) {
                lessTail.next = cur;
                cur.next = largerHead; //Be careful when changing cur.next when you're iterating a list.
                lessTail = cur;
            }
            
            if (temp == null) {
            	System.out.println(" temp:" + temp);
            }
            cur = temp;
        }
        
		System.out.println(newHead.val + " : " + newHead.next.val + " : " + newHead.next.next.val);
        
        return newHead; 
    }
}
