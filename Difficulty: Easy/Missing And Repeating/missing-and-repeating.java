import java.util.*;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        
        long sumN = (long) n * (n + 1) / 2;               
        long sumNSq = (long) n * (n + 1) * (2L * n + 1) / 6; 
        
        long sum = 0, sumSq = 0;
        for (int num : arr) {
            sum += num;
            sumSq += (long) num * num;
        }
        
        long diff = sum - sumN; 
        long diffSq = sumSq - sumNSq; 
        
        long sumDM = diffSq / diff; 
        
        long duplicate = (diff + sumDM) / 2;
        long missing = duplicate - diff;
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) duplicate);
        result.add((int) missing);
        return result;
    }
}
