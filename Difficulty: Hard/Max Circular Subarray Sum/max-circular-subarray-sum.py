class Solution:
    def maxCircularSum(self, arr):
        def kadane(nums):
            max_current = max_global = nums[0]
            for x in nums[1:]:
                max_current = max(x, max_current + x)
                max_global = max(max_global, max_current)
            return max_global

        total_sum = sum(arr)
        max_kadane = kadane(arr)

        
        inverted_arr = [-x for x in arr]
        max_inverted_kadane = kadane(inverted_arr)
        max_wrap = total_sum + max_inverted_kadane

        
        if max_kadane < 0:
            return max_kadane

        return max(max_kadane, max_wrap)
