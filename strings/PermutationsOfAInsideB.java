package strings;

import java.util.HashMap;

//Q. You are given two strings, A and B, of size N and M, respectively.
//   You have to find the count of all permutations of A present in B as a substring.
//   You can assume a string will have only lowercase letters.
public class PermutationsOfAInsideB {
    public int find(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int ans = 0;

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for(int i = 0; i < lenA; i++){
            char ch = A.charAt(i);
            mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
        }
        int match = 0;

        for(int i = 0; i < lenA; i++){
            char ch = B.charAt(i);
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);

            if(mapA.containsKey(ch) && mapB.get(ch) <= mapA.get(ch)){
                match++;
            }
        }
        if(match == lenA)ans++;

        int p1 = 0;
        int p2 = lenA;
        while(p2 < lenB){
            //remove case
            char rem = B.charAt(p1);
            if(mapA.containsKey(rem) && mapB.get(rem) <= mapA.get(rem)){
                match--;
            }
            mapB.put(rem, mapB.get(rem) - 1);

            if(mapB.get(rem) == 0){
                mapB.remove(rem);
            }

            //adding case
            char add = B.charAt(p2);
            mapB.put(add, mapB.getOrDefault(add, 0) + 1);
            if(mapA.containsKey(add) && mapB.get(add) <= mapA.get(add)){
                match++;
            }
            if(match == lenA)ans++;

            p1++;
            p2++;

        }
        return ans;
    }

}
