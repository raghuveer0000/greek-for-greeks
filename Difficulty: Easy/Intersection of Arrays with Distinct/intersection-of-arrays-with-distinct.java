class Solution {
    public static int intersectSize(int a[], int b[]) {
        // Your code here
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (map.containsKey(num) && map.get(num) > 0) {
                count++;
                map.put(num, map.get(num) - 1);
            }
        }

        return count;
    }
}