
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        
        while (head.next != null && head.next.next != null) { //If there are only one node, this check would handle it well.
            if (head.next.val == head.next.next.val) {
                 //Found the next two nodes have the same value. Node that here we still keep track the head pointer, which points to next node, and next's next node. It therefore provide us the flexibility to delete a node.
                 //Found all nodes that have the same value. That is, find the node that has a different value.
                 ListNode temp = head.next.next.next;
                 while (temp != null) {
                      if (temp.val == head.next.val) {
                           temp = temp.next;
                           continue;
                      }
                      break;
                 }
                 //Fond temp, which is either null or points to the node with a different value.
                 head.next.next = temp; //Tricky here, because we actually want head move to the
                 head = head.next; //temp can be null
            } else {
                //Not equal
                head = head.next;
            }
             if (head == null) { //This check can be hoist to the while loop condition.
                  break;
             }
        }
        //When return, simply use
        return dummyNode.next;
    } 
}
