package linkedList;

//Q. Merge two sorted linked lists, A and B, and return it as a new list.
public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null && B == null)return null;
        if(A == null)return B;
        if(B == null)return A;

        ListNode head = null;
        if(A.val < B.val){
            head = A;
            A = A.next;
        }
        else{
            head = B;
            B = B.next;
        }
        ListNode temp = head;
        while(A != null && B != null){
            if(A.val < B.val){
                temp.next = A;
                A = A.next;
            }
            else{
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }
        while(A != null){
            temp.next = A;
            A = A.next;
            temp = temp.next;
        }
        while(B != null){
            temp.next = B;
            B = B.next;
            temp = temp.next;
        }
        return head;
    }
}
