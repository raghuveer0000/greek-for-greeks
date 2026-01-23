class Solution {
    public int[] countOddEven(int[] arr) {
        // Code here
        int a[]=new int[2];
        int even=0;
        int odd=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        a[1]=even;
        a[0]=odd;
        return a;
    }
}