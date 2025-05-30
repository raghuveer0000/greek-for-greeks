class Solution {
    // Function to reverse words in a given string
    public String reverseWords(String s) {
        // Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
