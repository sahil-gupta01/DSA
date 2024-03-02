package strings;

//Q. Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
public class CountOccurrencesOfSubstring {
    public int count(String A) {
        int N = A.length();
        if(N<3)return 0;
        int ans =0;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<3;i++){
            str.append(A.charAt(i));
        }
        if(str.toString().equals("bob"))ans++;
        int j =3;
        while(j<N){
            str.deleteCharAt(0);
            str.append(A.charAt(j));
            if(str.toString().equals("bob"))ans++;
            j++;
        }
        return ans;
    }
}
