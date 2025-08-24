class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        
        if (m * k > n) return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        
        for (int day : arr) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(arr, k, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return canMakeBouquets(arr, k, m, left) ? left : -1;
    }

    
    private boolean canMakeBouquets(int[] arr, int k, int m, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloomDay : arr) {
            if (bloomDay <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; 
                    if (bouquets == m) return true;
                }
            } else {
                flowers = 0; 
            }
        }
        
        return bouquets >= m;
    }
}
