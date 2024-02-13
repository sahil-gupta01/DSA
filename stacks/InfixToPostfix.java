package stacks;

import java.util.Stack;

//Q. Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
//
//        String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
//
//        Find and return the postfix expression of A.
public class InfixToPostfix {
    public String solve(String A) {
        int N = A.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < N){
            char ch = A.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(st.size() > 0 && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();   //to remove the '('
            }
            else{
                while(st.size() > 0 && st.peek() != '(' && findPriority(st.peek()) >= findPriority(ch)){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    public int findPriority(char ch){
        if(ch == '+' || ch=='-')return 1;
        else if(ch == '*' || ch == '/')return 2;
        return 3;
    }
}
