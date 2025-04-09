class Solution:
    def articulationPoints(self, V, edges):
        # code here
        from collections import defaultdict

        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = [False] * V
        discovery = [-1] * V
        low = [-1] * V
        parent = [-1] * V
        articulation_points = set()
        time = 0

        def dfs(node):
            nonlocal time
            visited[node] = True
            discovery[node] = low[node] = time
            time += 1
            children = 0

            for neighbor in graph[node]:
                if not visited[neighbor]:
                    children += 1
                    parent[neighbor] = node
                    dfs(neighbor)

                    low[node] = min(low[node], low[neighbor])

                    if parent[node] == -1 and children > 1:
                        articulation_points.add(node)
                    if parent[node] != -1 and low[neighbor] >= discovery[node]:
                        articulation_points.add(node)
                elif neighbor != parent[node]:
                    low[node] = min(low[node], discovery[neighbor])

        for i in range(V):
            if not visited[i]:
                dfs(i)

        return sorted(articulation_points) if articulation_points else [-1]

#{ 
 # Driver Code Starts
import sys

sys.setrecursionlimit(int(1e7))


def main():
    tc = int(input())
    for _ in range(tc):
        V = int(input())
        E = int(input())
        edges = []
        for _ in range(E):
            u, v = map(int, input().split())
            edges.append([u, v])
        obj = Solution()
        ans = obj.articulationPoints(V, edges)
        ans.sort()
        print(" ".join(map(str, ans)))
        print("~")


if __name__ == "__main__":
    main()
# } Driver Code Ends