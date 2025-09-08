class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int sum=0;
        if(arr.length<=1)return false;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
            sum=arr[i]+arr[j];
            if(sum==target){
                return true;
            }
        }
        }
        return false;
    }
}