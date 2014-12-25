
public class SortList {
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode first = null;
        ListNode second = null;
        frontEndSplit(head, first, second); //get front and end.
        sortList(first);
        sortList(second);
        head = sortedMerge(first, second);
        return head;
    }
    
    ListNode sortedMerge(ListNode first, ListNode second) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                cur = first;
                first = first.next;
            } else {
                cur.next = second;
                cur = second;
                second = second.next;
            }
        }
        
        if (first != null) {
            cur.next = first;  
        }
        
        if (second != null) {
            cur.next = second;
        }
        
        return dummyNode.next;
    }
    
    void frontEndSplit(ListNode root, ListNode frist, ListNode second) {
        
        ListNode slow = root;
        ListNode fast = root;
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        
        second = slow.next;
        slow.next = null;
        frist = root;
    }
}
