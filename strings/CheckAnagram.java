package strings;

import java.util.HashMap;

//Q. You are given two lowercase strings A and B each of length N.
//    Return 1 if they are anagrams to each other and 0 if not.
public class CheckAnagram {
    public int check(String A, String B) {
        if(A.length()!=B.length())return 0;
        int N = A.length();
        int match=0;
        HashMap<Character,Integer> mapA = new HashMap<>();
        for(int i=0;i<N;i++){
            char ch = A.charAt(i);
            if(mapA.containsKey(ch)){
                mapA.put(ch,mapA.get(ch)+1);
            }
            else{
                mapA.put(ch,1);
            }
        }
        HashMap<Character,Integer> mapB = new HashMap<>();
        for(int i=0;i<N;i++){
            char ch = B.charAt(i);
            if(mapB.containsKey(ch)){
                mapB.put(ch,mapB.get(ch)+1);
            }
            else{
                mapB.put(ch,1);
            }
            if(mapA.containsKey(ch)==false)return 0;
            if(mapB.get(ch)<=mapA.get(ch)){
                match = match+1;
            }
            if(mapB.get(ch)>mapA.get(ch))return 0;
        }
        if(match == N)return 1;
        return 0;
    }
}
