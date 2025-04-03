from collections import deque

class Solution:
	def orangesRotting(self, mat):
		#Code her
		n = len(mat)
        m = len(mat[0])
        queue = deque()  
        fresh_count = 0
        
        
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 2: 
                    queue.append((i, j, 0))  
                elif mat[i][j] == 1: 
                    fresh_count += 1
        
        max_time = 0  
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  
        
        
        while queue:
            x, y, time = queue.popleft()
            max_time = max(max_time, time)
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m and mat[nx][ny] == 1:  
                    mat[nx][ny] = 2 
                    fresh_count -= 1
                    queue.append((nx, ny, time + 1))
        
       
        return max_time if fresh_count == 0 else -1


#{ 
 # Driver Code Starts
from queue import Queue

T = int(input())
for i in range(T):
    n = int(input())
    m = int(input())
    mat = []
    for _ in range(n):
        a = list(map(int, input().split()))
        mat.append(a)
    obj = Solution()
    ans = obj.orangesRotting(mat)
    print(ans)
    print("~")

# } Driver Code Ends