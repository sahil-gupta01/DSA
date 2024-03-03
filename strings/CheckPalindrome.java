package strings;

import java.util.HashMap;

//Q. Given a string A consisting of lowercase characters.
//   Check if characters of the given string can be rearranged to form a palindrome.
public class CheckPalindrome {
    public int solve(String A) {

        int N = A.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            char ch = A.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        int count=0;

        for(Character ele:map.keySet()){
            if(map.get(ele)%2==1){
                count++;
            }
        }
        if(count>1)return 0;
        else return 1;
    }
}
