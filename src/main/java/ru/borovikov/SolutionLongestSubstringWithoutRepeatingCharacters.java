package ru.borovikov;

import java.util.HashSet;
import java.util.Set;

public class SolutionLongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            while (seen.contains(ch)) {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(ch);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstringTheBestSolution(String s) {
        char[] lastSeen = new char[128];
        int start = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            int prevIndex = lastSeen[c];
            if (prevIndex > start) start = prevIndex;
            int currLen = i - start + 1;
            if (currLen > maxLen) maxLen = currLen;
            lastSeen[c] = (char) (i + 1);
        }

        return maxLen;
    }
}
