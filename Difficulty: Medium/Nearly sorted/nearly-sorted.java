import java.util.*;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < Math.min(arr.length, k + 1); i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
