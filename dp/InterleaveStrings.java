package dp;

//Q.Given A, B, C find whether C is formed by the interleaving of A and B

import java.util.Arrays;

public class InterleaveStrings {
    int[][] dp;
    public int isInterleave(String A, String B, String C) {
        int lenA = A.length();
        int lenB = B.length();
        int lenC = C.length();
        if(lenA + lenB != lenC)return 0;

        dp = new int[lenA+1][lenB+1];
        for(int i=0;i<lenA+1;i++){
            Arrays.fill(dp[i], -1);
        }
        return findInterleave(A, B, C, 0, 0, 0);
    }
    public int findInterleave(String A, String B, String C, int indA, int indB, int indC){
        if(indA == A.length() && indB == B.length()){
            if(indC == C.length())return 1;
            return 0;
        }

        if(dp[indA][indB] != -1)return dp[indA][indB];
        int ans = 0;

        if(indA < A.length() && A.charAt(indA) == C.charAt(indC)){
            ans = ans | findInterleave(A, B, C, indA+1, indB, indC+1);
        }
        if(indB < B.length() && B.charAt(indB) == C.charAt(indC)){
            ans = ans | findInterleave(A, B, C, indA, indB+1, indC+1);
        }

        return dp[indA][indB] = ans;
    }
}
