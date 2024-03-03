package strings;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public int maxLength(String A) {
        int N = A.length();
        HashSet<Character> set = new HashSet<>();
        int p2 = 0;
        int p1 = 0;
        int maxLength = 0;

        while(p2 < N){
            char ch = A.charAt(p2);
            if(!set.contains(ch)){
                int currLen = p2 - p1 + 1;
                maxLength = Math.max(currLen, maxLength);
                set.add(ch);
            }
            else{
                while(set.contains(ch)){
                    char rem = A.charAt(p1);
                    set.remove(rem);
                    p1++;
                }
                int currLen = p2 - p1 + 1;
                maxLength = Math.max(currLen, maxLength);
                set.add(ch);
            }
            p2++;
        }
        return maxLength;
    }
}
