package queue;

import java.util.Stack;

public class ImplementQueueUsingStack {
    static Stack<Integer> st1;
    static Stack<Integer> st2;

    ImplementQueueUsingStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        st1.push(X);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if(st2.size() > 0){
            return st2.pop();
        }
        while(st1.size() > 0){
            st2.push(st1.pop());
        }
        return st2.pop();
    }

    /** Get the front element of the queue. */
    static int peek() {
        if(st2.size() > 0){
            return st2.peek();
        }
        while(st1.size() > 0){
            st2.push(st1.pop());
        }
        return st2.peek();
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        if(st1.size() + st2.size() > 0)return false;
        return true;
    }
}
