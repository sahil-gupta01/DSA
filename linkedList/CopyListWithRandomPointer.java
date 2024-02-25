package linkedList;

//Q. standard question to copy a LL having random pointer
public class CopyListWithRandomPointer {
    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)return null;

        //make duplication of a node just int front of each node respectively
        //1 -> 1 -> 2 -> 2 -> 3 -> 3
        //    copy      copy      copy

        RandomListNode temp = head;
        while(temp != null){
            RandomListNode copyNode = new RandomListNode(temp.label);
            copyNode.next = temp.next;
            temp.next = copyNode;

            temp = copyNode.next;
        }

        //for random pointer of the copy nodes
        temp = head;
        while(temp != null){
            RandomListNode randomPointer = temp.random;
            RandomListNode copyNode = temp.next;
            if(randomPointer != null)
                copyNode.random = randomPointer.next;

            temp = copyNode.next;
        }

        temp = head;
        RandomListNode ans = head.next;

        while(temp.next.next != null){
            RandomListNode original = temp;
            RandomListNode copy = temp.next;

            original.next = copy.next;
            original = original.next;

            copy.next = original.next;

            temp = original;
            copy = copy.next;
        }
        temp.next = null;
        return ans;
    }
}
