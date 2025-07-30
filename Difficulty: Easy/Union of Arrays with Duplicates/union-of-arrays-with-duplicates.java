import java.util.*;
class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
         for (int num : a) {
            map.put(num, 1);
        }

        
        for (int num : b) {
            map.put(num, 1);
        }

    
        ArrayList<Integer> result = new ArrayList<>(map.keySet());
        Collections.sort(result); // optional if you want sorted result

        return result;
    }
}
