
class Solution:
    def isCycle(self, V, edges):
     
        adjacency_list = {i: [] for i in range(V)}
        for u, v in edges:
            adjacency_list[u].append(v)
        
      
        visited = [False] * V
        rec_stack = [False] * V
        
        
        def dfs(node):
            visited[node] = True
            rec_stack[node] = True
            
            for neighbor in adjacency_list[node]:
                if not visited[neighbor]:
                    if dfs(neighbor):
                        return True
                elif rec_stack[neighbor]:
                    return True
            
            rec_stack[node] = False
            return False
        
        
        for i in range(V):
            if not visited[i]:
                if dfs(i):
                    return True
        
        return False

#{ 
 # Driver Code Starts
from collections import deque


def main():
    tc = int(input())
    for _ in range(tc):
        V = int(input())
        E = int(input())
        edges = []
        for _ in range(E):
            u, v = map(int, input().split())
            edges.append((u, v))

        obj = Solution()
        ans = obj.isCycle(V, edges)
        print("true" if ans else "false")


if __name__ == "__main__":
    main()

# } Driver Code Ends