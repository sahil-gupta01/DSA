package linkedList;

public class PalindromeLL {
    public int lPalindrome(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode B = slow.next;
        slow.next = null;
        B = reverse(B);
        while(A!=null && B!=null){
            if(A.val != B.val)return 0;
            A = A.next;
            B = B.next;
        }
        return 1;
    }
    public ListNode reverse(ListNode B){
        ListNode curr = B;
        ListNode prev=null;
        while(curr!=null){
            ListNode frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        return prev;
    }
}
