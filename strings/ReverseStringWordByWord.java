package strings;

//Q. You are given a string A of size N.
//    Return the string A after reversing the string word by word.
public class ReverseStringWordByWord {
    public String solve(String A) {
        int N = A.length();
        int i=N-1;
        StringBuilder ans = new StringBuilder();
        while(i>=0){
            if(A.charAt(i)==' '){
                i--;
                continue;
            }
            StringBuilder word = new StringBuilder();
            while(i>=0 && A.charAt(i)!=' '){
                word.insert(0,A.charAt(i));
                i--;
            }
            if(ans.length()==0){
                ans.append(word);
            }
            else{
                ans.append(' ');
                ans.append(word);
            }
        }
        return ans.toString();
    }
}
