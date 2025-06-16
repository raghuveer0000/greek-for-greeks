class Solution:
    def minCost(self, heights, cost):
        def total_cost(target):
            return sum(abs(h - target) * c for h, c in zip(heights, cost))
        
        low, high = min(heights), max(heights)
        
        while low < high:
            mid = (low + high) // 2
            cost_mid = total_cost(mid)
            cost_next = total_cost(mid + 1)
            
            if cost_mid <= cost_next:
                high = mid
            else:
                low = mid + 1
        
        return total_cost(low)
