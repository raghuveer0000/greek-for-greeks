import java.util.*;

class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        Set<Integer> prefixSums = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;

            // Check conditions for zero-sum subarray
            if (sum == 0 || num == 0 || prefixSums.contains(sum)) {
                return true;
            }

            prefixSums.add(sum);
        }

        return false;
    }
}
