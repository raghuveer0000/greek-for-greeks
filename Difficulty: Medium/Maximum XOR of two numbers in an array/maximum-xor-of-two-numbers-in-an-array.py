#User function Template for python3

class TrieNode:
    def __init__(self):
        self.children = {}

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num):
        node = self.root
        for i in range(31, -1, -1): 
            bit = (num >> i) & 1
            if bit not in node.children:
                node.children[bit] = TrieNode()
            node = node.children[bit]

    def find_max_xor(self, num):
        node = self.root
        max_xor = 0
        for i in range(31, -1, -1):  
            bit = (num >> i) & 1
            opposite_bit = 1 - bit
            if opposite_bit in node.children:
                max_xor = (max_xor << 1) | 1
                node = node.children[opposite_bit]
            else:
                max_xor = (max_xor << 1)
                node = node.children[bit]
        return max_xor

class Solution:
    def maxXor(self, arr):
        
        trie = Trie()
        max_xor = 0
        
        
        trie.insert(arr[0])
        
        
        for num in arr[1:]:
            max_xor = max(max_xor, trie.find_max_xor(num))
            trie.insert(num)
        
        return max_xor



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        n = int(input())
        arr = list(map(int, input().split()))
        ob = Solution()
        print(ob.maxXor(arr))
        print("~")

# } Driver Code Ends