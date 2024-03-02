package strings;

//Q. Find the longest palindrome substring in the given string.
public class LongestPalindromeSubstring {

    public String longestPalindrome(String A) {
        int N = A.length();
        String ans = "";
        //for odd length
        for(int i=0;i<N;i++){
            int p1 = i;
            int p2 = i;
            String palin = isPalindrome(A,p1,p2);
            if(ans.length()<palin.length()){
                ans = palin;
            }
        }
        //for even length Palindrome
        for(int i=0;i<N;i++){
            int p1 = i;
            int p2 = i+1;
            String palin = isPalindrome(A,p1,p2);
            if(ans.length()<palin.length()){
                ans = palin;
            }
        }
        return ans;
    }
    public String isPalindrome(String A, int p1, int p2){
        int N = A.length();

        while(p1>=0 && p2<N && A.charAt(p1)==A.charAt(p2)){
            p1--;
            p2++;
        }
        p1++;p2--;
        return A.substring(p1,p2+1);
    }
}
