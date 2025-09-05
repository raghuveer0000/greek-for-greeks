// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        // code here
        int l=arr.length;
        if(l<=1)return;
         
         int first=arr[l-1];
         for(int i=l-1;i>0;i--){
             arr[i]=arr[i-1];
         }
         arr[0]=first;
    }
}