class Solution:
    def nextLargerElement(self, arr):
        n = len(arr)
        res = [-1] * n
        stack = []

        # Traverse the array twice to simulate circular nature
        for i in range(2 * n - 1, -1, -1):
            index = i % n
            while stack and arr[stack[-1]] <= arr[index]:
                stack.pop()
            if i < n and stack:
                res[index] = arr[stack[-1]]
            stack.append(index)

        return res
