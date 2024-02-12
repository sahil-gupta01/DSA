package stacks;

import java.util.Stack;

//Q.Given an expression string A, examine whether the pairs and the orders of
//      “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
public class BalancedParanthesis {
    public int solve(String A) {
        int N = A.length();
        Stack<Character> st = new Stack<>();

        for(int i =0;i<N;i++){
            char ch = A.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else if(ch == ')'){
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }
                else return 0;
            }
            else if(ch == '}'){
                if(st.size() > 0 && st.peek() == '{'){
                    st.pop();
                }
                else return 0;
            }
            else if(ch == ']'){
                if(st.size() > 0 && st.peek() == '['){
                    st.pop();
                }
                else return 0;
            }
        }
        return (st.size() == 0)?1:0;
    }
}
