//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public String findOrder(String[] words) {
        // code here
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            
            if (word1.startsWith(word2) && word1.length() > word2.length()) {
                return "";
            }
            
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    char from = word1.charAt(j);
                    char to = word2.charAt(j);
                    if (!graph.get(from).contains(to)) {
                        graph.get(from).add(to);
                        inDegree.put(to, inDegree.get(to) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (order.length() != inDegree.size()) {
            return "";
        }
        
        return order.toString();
    }
}
        
    



//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends