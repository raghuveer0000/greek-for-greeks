class Solution:
	def floodFill(self, image, sr, sc, newColor):
		#Code here
        originalColor = image[sr][sc]
        if originalColor == newColor:  
            return image

        def dfs(row, col):
            if row < 0 or row >= len(image) or col < 0 or col >= len(image[0]) or image[row][col] != originalColor:
                return
            image[row][col] = newColor  
            dfs(row - 1, col) 
            dfs(row + 1, col)  
            dfs(row, col - 1) 
            dfs(row, col + 1)  

        dfs(sr, sc) 
        return image


#{ 
 # Driver Code Starts
import sys

sys.setrecursionlimit(10**7)

T = int(input())  # Read number of test cases
for i in range(T):
    n = int(input())
    m = int(input())

    # Reading the image matrix
    image = []
    for _ in range(n):
        image.append(list(map(int, input().split())))

    # Read starting row, column, and new color
    sr = int(input())
    sc = int(input())
    newColor = int(input())

    # Create an instance of the Solution class and apply floodFill
    obj = Solution()
    ans = obj.floodFill(image, sr, sc, newColor)

    for row in ans:
        print(" ".join(map(str, row)))
    print("~")

# } Driver Code Ends