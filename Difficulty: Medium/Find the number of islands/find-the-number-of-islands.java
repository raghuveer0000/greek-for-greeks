//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (grid[i][j] == 'L') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
       
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'W') {
            return;
        }

    
        grid[i][j] = 'W';

        
        dfs(grid, i + 1, j);    
        dfs(grid, i - 1, j);    
        dfs(grid, i, j + 1);     
        dfs(grid, i, j - 1);     
        dfs(grid, i + 1, j + 1); 
        dfs(grid, i + 1, j - 1); 
        dfs(grid, i - 1, j + 1);
        dfs(grid, i - 1, j - 1); 
        
    }
}