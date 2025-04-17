class Solution:
    def findMinCycle(self, V, edges):
        # code here
        from collections import defaultdict
        import heapq

        graph = defaultdict(list)
        for u, v, w in edges:
            graph[u].append((v, w))

        min_cycle = sys.maxsize

        for u, v, w in edges:
            
            if (v, w) in graph[u]:
                graph[u].remove((v, w))
            if (u, w) in graph[v]:
                graph[v].remove((u, w))

            
            dist = [sys.maxsize] * V
            dist[u] = 0
            pq = [(0, u)]

            while pq:
                d, node = heapq.heappop(pq)
                if d > dist[node]:
                    continue
                for neighbor, weight in graph[node]:
                    if dist[node] + weight < dist[neighbor]:
                        dist[neighbor] = dist[node] + weight
                        heapq.heappush(pq, (dist[neighbor], neighbor))

            if dist[v] != sys.maxsize:
                min_cycle = min(min_cycle, dist[v] + w)

            
            graph[u].append((v, w))
            graph[v].append((u, w))

        return min_cycle if min_cycle != sys.maxsize else -1

        



#{ 
 # Driver Code Starts
# Initial Template for Python 3
import sys
import heapq

# Position this line where user code will be pasted.


def main():
    t = int(input())
    for _ in range(t):
        V = int(input())
        E = int(input())
        edges = []
        for _ in range(E):
            u, v, w = map(int, input().split())
            edges.append([u, v, w])
            edges.append([v, u, w])  # Since the graph is undirected

        obj = Solution()
        res = obj.findMinCycle(V, edges)

        print(res)


if __name__ == "__main__":
    main()

# } Driver Code Ends