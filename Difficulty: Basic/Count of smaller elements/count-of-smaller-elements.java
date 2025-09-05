
class Solution {
    public int countOfElements(int x, List<Integer> arr) {
        // Code here
        int count=0;
        for(int num:arr){
            if(num<=x){
                count=count+1;
        }
        }
        return count;
    }
}