class Solution {
    public int[] countOddEven(int[] arr) {
        // Code here
        int odd=0;
        int even=0;
        for(int num:arr){
            if(num%2==0){
                even=even+1;
            }
            else{
                odd++;
            }
        }
        int a[]={odd,even};
        return a;
    }
}