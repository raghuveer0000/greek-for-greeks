import java.util.*;

class Solution {
    static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(num);
                resultStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if (c == ']') {
                int repeat = counts.pop();
                StringBuilder prev = resultStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(current);
                }
                current = prev;
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
