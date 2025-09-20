class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];

        for (int i = 0; i < n; i++) nextGreater[i] = n;
        for (int i = 0; i < n; i++) prevGreater[i] = -1;

        java.util.Stack<Integer> st = new java.util.Stack<>();
        // Find next greater on right
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }
        st.clear();
        // Find next greater on left
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int windowSize = nextGreater[i] - prevGreater[i] - 1;
            if (arr[i] <= windowSize) {
                maxLength = Math.max(maxLength, windowSize);
            }
        }
        return maxLength;
    }
}
