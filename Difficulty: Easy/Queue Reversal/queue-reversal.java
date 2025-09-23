import java.util.*;

class Solution {
    public void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int front = q.poll();
        reverseQueue(q);
        q.add(front);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Queue<Integer> q = new LinkedList<>(Arrays.asList(5, 10, 15, 20, 25));
        
        System.out.println("Original Queue: " + q);
        sol.reverseQueue(q);
        System.out.println("Reversed Queue: " + q);
    }
}

