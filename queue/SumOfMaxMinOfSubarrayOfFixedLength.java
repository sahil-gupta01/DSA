package queue;

import java.util.ArrayDeque;
import java.util.Deque;

//Q. Given an array A of both positive and negative integers.
//   Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
public class SumOfMaxMinOfSubarrayOfFixedLength {
    public int findSum(int[] A, int B) {
        int N = A.length;
        long max = calcMax(A,B);
        long mod = 1000*1000*1000+7;
        long min = calcMin(A,B);
        return (int)((max+min+mod)%mod);
    }
    public long calcMax(int[] A,int B){
        long mod = 1000*1000*1000+7;
        int N = A.length;
        long sum=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<B;i++){
            while(dq.size()>0 && A[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(A[i]);
        }
        sum = (sum+(long)dq.getFirst()+mod)%mod;

        int st = 1;int e = B;
        while(e<N){
            //dropping
            int drop = A[st-1];
            if(drop==dq.getFirst()){
                dq.removeFirst();
            }
            //adding
            while(dq.size()>0 && A[e]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(A[e]);
            sum = (sum+(long)dq.getFirst()+mod)%mod;

            st++; e++;
        }
        return sum;
    }
    public long calcMin(int[] A,int B){
        long mod = 1000*1000*1000+7;
        int N = A.length;
        long sum=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<B;i++){
            while(dq.size()>0 && A[i]<dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(A[i]);

        }
        sum = (sum+(long)dq.getFirst()+mod)%mod;

        int st = 1;int e = B;
        while(e<N){
            //dropping
            int drop = A[st-1];
            if(drop==dq.getFirst()){
                dq.removeFirst();
            }
            //adding
            while(dq.size()>0 && A[e]<dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(A[e]);
            sum = (sum+(long)dq.getFirst()+mod)%mod;

            st++; e++;
        }
        return sum;
    }
}
