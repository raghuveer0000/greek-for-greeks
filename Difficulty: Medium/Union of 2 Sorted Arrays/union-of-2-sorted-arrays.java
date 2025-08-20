import java.util.*;
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:a){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:b){
            map.put(num,map.getOrDefault(num,0)+1);
        }
          ArrayList<Integer> union = new ArrayList<>(map.keySet());
          Collections.sort(union);
          return union;
    }
}
