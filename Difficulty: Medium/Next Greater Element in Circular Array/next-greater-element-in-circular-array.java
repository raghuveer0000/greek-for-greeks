import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
            int curr = arr[i % n];
            while (!st.isEmpty() && arr[st.peek()] < curr) {
                res.set(st.pop(), curr);
            }
            if (i < n) {
                st.push(i);
            }
        }
        return res;
    }
}
