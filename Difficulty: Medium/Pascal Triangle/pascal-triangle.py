#User function Template for python3
class Solution:

	def nthRowOfPascalTriangle(self, n):
	    # code here
	    row = [1]  
        for k in range(1, n):
            row.append(row[k - 1] * (n - k) // k)  
        return row


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    tc = int(input())
    while tc > 0:
        n = int(input())
        ob = Solution()
        ans = ob.nthRowOfPascalTriangle(n)
        for x in ans:
            print(x, end=" ")
        print()
        tc = tc - 1
        print("~")
# } Driver Code Ends