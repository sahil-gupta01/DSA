package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Q.  Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
//    NOTE: All the A integers will fit in 32-bit integers.
//    eg - [1, 2, 3, 11, 12, 13, 21]

public class PatternFormation {
    public ArrayList<Integer> solve(int A) {
        Queue< Integer > q = new LinkedList< Integer >();
        ArrayList < Integer > ans = new ArrayList < > ();

        q.add(1);
        q.add(2);
        q.add(3);
        int count = 0;

        while(count != A){
            int ele = q.remove();
            count ++;
            ans.add(ele);
            q.add(ele*10+1);
            q.add(ele*10+2);
            q.add(ele*10+3);
        }
        return ans;
    }
}
