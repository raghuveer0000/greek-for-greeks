#User function Template for python3
class Solution:
    def findDuplicate(self, arr):
        #code here
        seen = set()  
        for num in arr:
            if num in seen:
                return num  
            seen.add(num)  
        return -1

#{ 
 # Driver Code Starts
# Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().strip().split()))

        ob = Solution()
        print(ob.findDuplicate(arr))
        print("~")

# } Driver Code Ends