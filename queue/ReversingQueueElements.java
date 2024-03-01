package queue;

import java.util.Stack;

//Q. Reverse first B elements of the given array

public class ReversingQueueElements {
    public int[] reverseElements(int[] A, int B) {
        int N = A.length;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<B;i++){
            st.push(A[i]);
        }
        for(int i =0;i<B;i++){
            A[i] = st.pop();
        }
        return A;
    }
}
