package org.example.two_pointers;

public class StringCompression {
    public int compress(char[] chars) {
        int idx = 0; // Index to write compressed characters
        int i = 0;   // Index to read characters

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count consecutive occurrences
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[idx++] = currentChar;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[idx++] = c;
                }
            }
        }

        return idx;
    }
}
