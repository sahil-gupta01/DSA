package linkedList;

//Q. You are given two linked lists, A and B, representing two non-negative numbers.
//
//        The digits are stored in reverse order, and each of their nodes contains a single digit.
//
//        Add the two numbers and return it as a linked list.
public class AddingTwoLL {
    public ListNode addTwoLL(ListNode A, ListNode B) {
        if(A == null && B == null)return null;
        if(A == null)return B;
        if(B == null)return A;

        int carry = 0;
        ListNode head = new ListNode(1);
        ListNode temp = head;

        while(A!=null && B != null){
            int sum = A.val + B.val + carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;

            temp = temp.next;
            A = A.next;
            B = B.next;
        }
        while(A != null){
            int sum = A.val + carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;

            temp = temp.next;
            A = A.next;
        }
        while(B != null){
            int sum = B.val + carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;

            temp = temp.next;
            B = B.next;
        }
        if(carry > 0){
            temp.next = new ListNode(carry);
        }
        return head.next;
    }
}
