package stacks;

import java.util.Stack;

//Q.  An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//        Valid operators are +, -, *, /. Each string may be an integer or an operator.
//
//        Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
public class EvaluateExpression {
    public int evaluateExp(String[] A) {
        int N = A.length;
        Stack<Integer> st = new Stack<>();

        int i=0;
        while(i < N){
            String currStr = A[i];
            if(currStr.equals("+")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 + num2);
            }
            else if(currStr.equals("-")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 - num2);
            }
            else if(currStr.equals("*")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 * num2);
            }
            else if(currStr.equals("/")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1 / num2);
            }
            else{
                st.push(Integer.parseInt(currStr));
            }
            i++;
        }
        return st.pop();
    }
}
