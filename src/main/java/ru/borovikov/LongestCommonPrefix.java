package ru.borovikov;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];

            if (current.length() < prefix.length()) {
                prefix = prefix.substring(0, current.length());
            }

            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) != current.charAt(j)) {
                    prefix = prefix.substring(0, j);
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefixTheBEstSolve(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];

            int j = 0;
            while (j < prefix.length() && j < current.length() && prefix.charAt(j) == current.charAt(j)) {
                j++;
            }

            prefix = prefix.substring(0, j);
            if (prefix.isEmpty()) break;
        }

        return prefix;
    }

    public static String longestCommonPrefixAnotherSolve(String[] strs) {
        Arrays.sort(strs);
        StringBuilder ans = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
