package linkedList;

//Q.Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
//    (i) a next pointer to the next node,
//    (ii) a bottom pointer to a linked list where this node is head.
//  Each of the sub-linked-list is in sorted order.
//  Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
//  Note: The flattened list will be printed using the bottom pointer instead of next pointer.

//  Note: All linked lists are sorted and the resultant linked list should also be sorted
public class FlattingList {
    public class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
    ListNode flatten(ListNode root) {
        if(root == null)return null;
        if(root.right == null)return root;
        ListNode A = root;
        ListNode B = root.right;

        while(B != null){
            A = flatten(A, B);
            B = B.right;
        }
        return A;
    }
    ListNode flatten(ListNode A, ListNode B){
        ListNode head = null;

        if(A.val < B.val){
            head = A;
            A = A.down;
        }
        else{
            head = B;
            B = B.down;
        }

        ListNode temp = head;
        while(A != null && B != null){
            if(A.val < B.val){
                temp.down = A;
                A = A.down;
            }
            else{
                temp .down = B;
                B = B.down;
            }
            temp = temp.down;
        }
        if(A != null){
            temp.down = A;
        }
        if(B != null){
            temp.down = B;
        }
        return head;
    }

}
