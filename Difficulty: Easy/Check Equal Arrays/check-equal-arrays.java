class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        if(a.length!=b.length) return false;
        for(int num:a){
            map.put(num,map.getOrDefault(num,0)+1);
            
        }
        for(int num:b){
        if (!map.containsKey(num)) {
            return false;
        }
        else{
            
            map.put(num,map.get(num)-1);
            if (map.get(num) == 0) {
                    map.remove(num); 
                }
        }
        }
        return map.isEmpty();
    }
}