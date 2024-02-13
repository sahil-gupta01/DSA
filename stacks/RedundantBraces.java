package DSA.src.stacks;

import java.util.Stack;

//Q. Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
//
//        Check whether A has redundant braces or not.
public class RedundantBraces {
    public int braces(String A) {
        int N = A.length();

        Stack<Character> st = new Stack<>();

        for(int i =0;i<N;i++){
            char ch = A.charAt(i);

            if(ch == '('){
                st.push(ch);
                continue;
            }
            else if(ch >= 'a' && ch <= 'z'){
                continue;
            }
            else if(ch == ')'){
                if(st.peek() == '(')return 1;

                while(st.peek() > 0 && st.peek() != '('){
                    st.pop();
                }
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        return 0;
    }

}
