package DSA.src.arrays;

//Q. You are given an array nums consisting of positive integers.
//   Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
//   The frequency of an element is the number of occurrences of that element in the array.


public class CountElementWithMaxFreq {
    public int maxFrequencyElements(int[] nums) {
        int[] freqArr = new int[101];

        for(Integer num : nums){
            freqArr[num]++;
        }
        int maxFreq = 0;
        for(int i = 0; i < 101; i++){
            maxFreq = Math.max(maxFreq, freqArr[i]);
        }

        int ans = 0;
        for(Integer freq : freqArr){
            if(freq == maxFreq){
                ans += freq;
            }
        }
        return ans;
    }
}
