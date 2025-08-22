// User function Template for Java
import java.util.*;

class Solution {
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            int a = arr1.get(i), b = arr2.get(j), c = arr3.get(k);

            if (a == b && b == c) {
                if (result.isEmpty() || result.get(result.size() - 1) != a) {
                    result.add(a);
                }
                i++; j++; k++;
            } else if (a < b) {
                i++;
            } else if (b < c) {
                j++;
            } else {
                k++;
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }
}
