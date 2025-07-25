class Solution {
    static int factorial(int n) {
        // code here
        int sum=1;
        for(int i=1;i<=n;i++){
            sum=sum*i;
        }
        return sum;
    }
}