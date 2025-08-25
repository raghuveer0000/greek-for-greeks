import java.util.Arrays;

class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        long low = (n % 2 == 1) ? arr[n / 2] : (arr[n / 2] + arr[n / 2 - 1]) / 2;
        long high = low + k + 1;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canMakeMedian(arr, k, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int)(low - 1);
    }

    
    private boolean canMakeMedian(int[] arr, int k, long target) {
        int n = arr.length;
        long required = 0;
        if (n % 2 == 1) {
            
            for (int i = n / 2; i < n; i++) {
                if (arr[i] < target) {
                    required += (target - arr[i]);
                    if (required > k)
                        return false;
                }
            }
        } else {
    
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            long currentSumMid = arr[mid1] + arr[mid2];
            if (currentSumMid < target * 2) {
        
                required += (target * 2 - currentSumMid);
                if (required > k)
                    return false;
            }
            
            for (int i = mid2 + 1; i < n; i++) {
                if (arr[i] < target) {
                    required += (target - arr[i]);
                    if (required > k)
                        return false;
                }
            }
        }
        return required <= k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 3, 4, 5};
        int k1 = 3;
        System.out.println(sol.maximizeMedian(arr1, k1));  

        int[] arr2 = {1, 3, 6, 4, 2};
        int k2 = 10;
        System.out.println(sol.maximizeMedian(arr2, k2));  
    }
}
