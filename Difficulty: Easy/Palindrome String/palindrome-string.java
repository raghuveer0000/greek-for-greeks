class Solution {
    boolean isPalindrome(String s) {
        // code here
        int i=0;
        int j=s.length()-1;
        int count=0;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}