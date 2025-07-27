class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (rows[i]) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = 0;
                }
            }
        }

       
        for (int j = 0; j < m; j++) {
            if (cols[j]) {
                for (int i = 0; i < n; i++) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
