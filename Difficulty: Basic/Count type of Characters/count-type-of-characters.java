//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		int[] res = new Sol().count (s);
    		
    		for (int i = 0; i < 4; i++)
    		    System.out.println (res[i]);
        
System.out.println("~");
}
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int[] count (String s)
    {
        // your code here   
        int uppercount=0,lowercount=0,numcount=0,spechart=0;
        for(int i=0;i<s.length();i++){
             char ch = s.charAt(i);
            if(ch>='A' && ch<='Z'){
                uppercount++;
            }
            else if(ch>='a' && ch<='z'){
                lowercount++;
            }
            else if(ch>='0' && ch<='9'){
                numcount++;
            }
            else{
                spechart++;
            }
        }
             return new int[] {uppercount, lowercount, numcount, spechart};
    }
}