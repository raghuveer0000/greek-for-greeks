import java.util.*;

class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = getPrimeFactorization(k);
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();

            int exponentInFactorial = countPrimeInFactorial(n, prime);
            int maxPower = exponentInFactorial / exponentInK;

            result = Math.min(result, maxPower);
        }

        return result;
    }

    // Count how many times 'prime' divides n!
    private int countPrimeInFactorial(int n, int prime) {
        int count = 0;
        while (n > 0) {
            n /= prime;
            count += n;
        }
        return count;
    }

    // Factorize k into prime factors and their exponents
    private Map<Integer, Integer> getPrimeFactorization(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            map.put(k, 1);
        }
        return map;
    }
}
