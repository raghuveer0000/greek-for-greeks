#User function Template for python3

class Solution:
    def sumOfSeries(self,n):
        #code here
        sum=0;
        for i in range(1,n+1):
            sum=sum+(i**3)
        return sum