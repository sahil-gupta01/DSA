package arrays;

//Q. Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
public class CountSort {
    public int[] solve(int[] A) {
        int N = A.length;
        int max = Integer.MIN_VALUE;

        for(Integer num : A){
            max = Math.max(num, max);
        }
        int[] countArr = new int[max+1];
        for(Integer num : A){
            countArr[num]++;
        }
        int ind = 0;
        for(int i = 0; i < countArr.length; i++ ){
            int num = i;
            int freq = countArr[num];

            while(freq > 0){
                A[ind] = num;
                freq--;
                ind++;
            }
        }
        return A;
    }
}
