class Solution:
    def isBridge(self, V, edges, c, d):
        # code here 
        graph = [[] for _ in range(V)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        
        def dfs(node, visited):
            visited[node] = True
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    dfs(neighbor, visited)
        
        
        visited = [False] * V
        initial_components = 0
        for i in range(V):
            if not visited[i]:
                initial_components += 1
                dfs(i, visited)
        
        
        graph[c].remove(d)
        graph[d].remove(c)
        
       
        visited = [False] * V
        components_after_removal = 0
        for i in range(V):
            if not visited[i]:
                components_after_removal += 1
                dfs(i, visited)
        graph[c].append(d)
        graph[d].append(c)
        
      
        return components_after_removal > initial_components


#{ 
 # Driver Code Starts
import sys

sys.setrecursionlimit(10**7)
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        V = int(input())
        E = int(input())
        adj = [[] for _ in range(V)]
        edges = []

        for _ in range(E):
            u, v = map(int, input().split())
            adj[u].append(v)
            adj[v].append(u)
            edges.append([u, v])

        c = int(input())
        d = int(input())

        obj = Solution()
        l = obj.isBridge(V, edges, c, d)

        if l:
            print("true")
        else:
            print("false")

        print("~")

# } Driver Code Ends