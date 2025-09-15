class Solution {
    public boolean stringStack(String pat, String tar) {
        int i = pat.length() - 1; // pointer on pat
        int j = tar.length() - 1; // pointer on tar

        while (i >= 0 && j >= 0) {
            if (pat.charAt(i) == tar.charAt(j)) {
                
                i--;
                j--;
            } else {
                
                i--;   
                if (i >= 0) {
                    i--; 
                }
            }
        }

        
        return j < 0;
    }
}
