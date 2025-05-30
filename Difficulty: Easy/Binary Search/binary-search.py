class Solution:
    def binarysearch(self, arr, k):
        low = 0
        high = len(arr) - 1
        result = -1

        while low <= high:
            mid = (low + high) // 2
            if arr[mid] == k:
                result = mid
                high = mid - 1  # Continue search in the left half for smallest index
            elif arr[mid] < k:
                low = mid + 1
            else:
                high = mid - 1

        return result
