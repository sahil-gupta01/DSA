package DSA.src.strings;

//Q. Given two strings - a text A and a pattern B, having lower-case alphabetic characters.
//   You have to find the number of times pattern B is present in pattern A;
public class PatternMatchingUsingLsp {
    public int findPatterCount(final String A, final String B) {
        int lenA = A.length();
        int lenB = B.length();
        String str = B + "@" + A;

        int[] LSP = calcLsp(str);
        int ans = 0;

        for(Integer count : LSP){
            if(count == lenB)ans++;
        }

        return ans;
    }
    public int[] calcLsp(String str){
        int[] LSP = new int[str.length()];
        LSP[0] = 0;

        for(int i = 1; i < str.length(); i++){
            int x = LSP[i-1];
            while( str.charAt(x) != str.charAt(i) ){
                if(x == 0){
                    x = -1;
                    break;
                }
                x = LSP[x-1];
            }
            LSP[i] = x + 1;
        }
        return LSP;
    }
}
