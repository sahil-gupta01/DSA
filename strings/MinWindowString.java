package strings;

import java.util.HashMap;

//Q. Given a string A and a string B, find the window with minimum length in A,
//    which will contain all the characters in B in linear time complexity.
public class MinWindowString {
    public String minWindow(String A, String B) {
        int N = A.length();
        int K = B.length();
        if(K>N)return "";

        String ans= A;
        boolean isContain = false;
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character,Integer> mapB = new HashMap<>();
        for(int i=0;i<K;i++){
            char ch = B.charAt(i);
            if(mapB.containsKey(ch)){
                mapB.put(ch,mapB.get(ch)+1);
            }
            else{
                mapB.put(ch,1);
            }
        }
        int match =0;
        int p1=0;int p2 =0;
        while(p2<N){
            char ch = A.charAt(p2);
            if(mapA.containsKey(ch)){
                mapA.put(ch, mapA.get(ch)+1);
            }
            else{
                mapA.put(ch, 1);
            }
            if(mapB.containsKey(ch) && mapA.get(ch) <= mapB.get(ch)){
                match++;
            }
            while(match == K){
                isContain=true;
                //System.out.println(A.substring(p1,p2+1));
                int len = p2-p1+1;
                if(len<ans.length()){
                    ans = A.substring(p1,p2+1);
                    //System.out.println("and ans is "+ans);
                }
                char drop = A.charAt(p1);
                if(mapB.containsKey(drop) && mapA.get(drop) <= mapB.get(drop)){
                    match--;
                }
                mapA.put(drop, mapA.get(drop)-1);
                p1++;
            }
            p2++;
        }
        if(!isContain)return "";
        return ans;
    }
}
