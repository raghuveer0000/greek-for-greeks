// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        // code here
        int len=arr.length;
        int last=arr[len-1];
        for(int i=len-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=last;
    }
}