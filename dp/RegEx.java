package dp;

//Q.Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
//
//        ' . ' : Matches any single character.
//        ' * ' : Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).

public class RegEx {
    public int isMatch(final String A, final String B) {
        int lenA = A.length();
        int lenB = B.length();

        int[][] dp = new int[lenA+1][lenB+1];
        dp[0][0] = 1;
        for(int j=1;j<lenB+1;j++){
            if(B.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for(int i=1;i<lenA+1;i++){
            for(int j=1;j<lenB+1;j++){
                if(A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(B.charAt(j-1) == '*'){

                    //including *
                    if(B.charAt(j-1-1) == A.charAt(i-1) || B.charAt(j-1-1) == '.'){
                        dp[i][j] = dp[i-1][j];
                    }
                    //not including *
                    dp[i][j] = dp[i][j] | dp[i][j-2];
                }
            }
        }
        return dp[lenA][lenB];
    }

}
