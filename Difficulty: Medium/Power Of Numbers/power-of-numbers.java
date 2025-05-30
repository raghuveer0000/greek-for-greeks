class Solution {
    public int reverseExponentiation(int n) {
        int reverse = 0, temp = n;

        
        while (temp > 0) {
            reverse = reverse * 10 + (temp % 10);
            temp = temp / 10;
        }

        
        return (int)Math.pow(n, reverse);
    }
}
