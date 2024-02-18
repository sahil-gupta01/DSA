package linkedList;
// Q. You are given a linked list that contains a loop.
//        You need to find the node, which creates a loop and
//        break it by making the node point to NULL.
public class RemoveCycleInLinkedList {
    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        boolean isCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle == false){
            return A;
        }
        ListNode p1 = A;
        while(p1 != slow){
            p1 = p1.next;
            slow = slow.next;
        }
        while(p1.next != slow){
            p1 = p1.next;
        }
        p1.next = null;
        return A;
    }
}
