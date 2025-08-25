import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length < 2) return res;

        Arrays.sort(arr);                  
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == 0) {
                res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j])));

                
                int leftVal = arr[i], rightVal = arr[j];
                while (i < j && arr[i] == leftVal) i++;
                while (i < j && arr[j] == rightVal) j--;
            } else if (sum < 0) {
                
                int leftVal = arr[i];
                while (i < j && arr[i] == leftVal) i++;
            } else { // sum > 0
                
                int rightVal = arr[j];
                while (i < j && arr[j] == rightVal) j--;
            }
        }
        return res;
    }

    
    public static void main(String[] args) {
        int[] arr = {-8, -10, -10, -10, 10, 6, 1, 10};
        ArrayList<ArrayList<Integer>> pairs = getPairs(arr);
        for (ArrayList<Integer> p : pairs) {
            System.out.println(p.get(0) + " " + p.get(1));
        }
    }
}
