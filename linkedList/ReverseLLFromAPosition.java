package linkedList;

//Q. Reverse a linked list A from position B to C.
public class ReverseLLFromAPosition {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(A.next==null)return A;
        ListNode ite = A;
        if(B==1){
            return reverse(A,C,B);
        }
        int temp = B;
        while(B>2){
            ite = ite.next;
            B--;
        }
        ite.next = reverse(ite.next, C, temp);
        return A;
    }
    public ListNode reverse(ListNode curr, int C, int B){
        ListNode first = curr;
        ListNode prev=null;
        int iteration = C-B+1;
        while(iteration>0){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
            iteration--;
        }
        first.next = curr;
        return prev;
    }
}
