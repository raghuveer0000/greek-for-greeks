class Solution:
    # Returns shortest distances from src to all other vertices
    def dijkstra(self, V, edges, src):
        # code here
        adj = {i: [] for i in range(V)}
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))
        
        
        distances = [float('inf')] * V
        distances[src] = 0
        min_heap = [(0, src)]  
        
        
        while min_heap:
            curr_dist, curr_node = heapq.heappop(min_heap)
            
            
            for neighbor, weight in adj[curr_node]:
                distance = curr_dist + weight
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(min_heap, (distance, neighbor))
        
        return distances


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

        src = int(input())

        obj = Solution()
        res = obj.dijkstra(V, edges, src)

        print(" ".join(map(str, res)))
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends