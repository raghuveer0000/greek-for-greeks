class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        ArrayList<Integer>a=new ArrayList<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            
        }
        for(int i=1;i<=n;i++){
            
            if(map.containsKey(i)){
                a.add(map.get(i));
                
        }
        else{
            a.add(0);
        }
        }
        return a;
    }
}
