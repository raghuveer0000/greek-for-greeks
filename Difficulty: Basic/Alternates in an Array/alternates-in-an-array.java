class Solution {
    public ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<arr.length;i=i+2){
            res.add(arr[i]);
        }
        return res;
    }
}