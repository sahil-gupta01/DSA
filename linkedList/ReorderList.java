package linkedList;

//Q.      You are given a linked list that contains a loop.
//        You need to find the node, which creates a loop and
//        break it by making the node point to NULL.
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode B = slow.next;
        slow.next = null;
        B = reverse(B);

        ListNode head = A;
        ListNode temp = head;
        A = A.next;

        while(A != null && B != null){
            temp.next = B;
            B = B.next;
            temp = temp.next;

            temp.next = A;
            A = A.next;
            temp = temp.next;
        }

        if(A != null){
            temp.next = A;
        }
        if(B!=null){
            temp.next = B;
        }
        return head;
    }
    public ListNode reverse(ListNode A){
        ListNode curr = A;
        ListNode prev = null;
        while(curr != null){
            ListNode frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        return prev;
    }
}
