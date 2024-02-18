package linkedList;

//Q. Given a linked list, swap every two adjacent nodes and return its head.
//   You must solve the problem without modifying the values in the list's
//   nodes (i.e., only nodes themselves may be changed.)


public class SwapNodes {
    public ListNode swapPairs(ListNode A) {
        if(A == null || A.next == null)return A;

        ListNode temp = A;
        while(temp != null && temp.next != null){
            int node1 = temp.val;
            temp.val = temp.next.val;
            temp.next.val = node1;

            if(temp.next.next != null){
                temp = temp.next.next;
            }
            else{
                break;
            }
        }
        return A;
    }
}
