package linkedList;

//Q.You are given a singly linked list having head node A. You have to reverse the linked list
//        and return the head node of that reversed list.

public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
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
