import java.util.*;

class Solution {
    public static int firstRepeated(int[] arr) {
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (firstIndexMap.containsKey(arr[i])) {
               
                minIndex = Math.min(minIndex, firstIndexMap.get(arr[i]));
            } else {
                
                firstIndexMap.put(arr[i], i);
            }
        }

        return (minIndex == Integer.MAX_VALUE) ? -1 : (minIndex + 1); 
    }
}
