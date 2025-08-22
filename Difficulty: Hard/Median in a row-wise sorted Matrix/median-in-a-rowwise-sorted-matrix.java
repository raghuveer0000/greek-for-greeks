import java.util.Arrays;
class Solution {
    public int median(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int a[]=new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[k]=mat[i][j];
                k++;
            }
        }
        Arrays.sort(a);
        int len=a.length;
        if((len/2)!=0){
            return a[len/2];
        }
        else if(len<=1){
            return a[0];
        }
        else{
            return (a[len/2]+ a[(len/2)- 1])/2;

        }
    }
}