class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        
        // If students are more than books
        if (k > n) return -1;
        
        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); 
            high += pages;            
        }
        
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return result;
    }
    
    private boolean isPossible(int[] arr, int k, int mid) {
        int students = 1, pages = 0;
        
        for (int book : arr) {
            if (pages + book > mid) {
                students++;
                pages = book; 
                
                if (students > k) return false;
            } else {
                pages += book;
            }
        }
        return true;
    }
}
