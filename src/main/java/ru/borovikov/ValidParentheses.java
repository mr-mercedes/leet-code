package ru.borovikov;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() == 1) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char reverse = 0;
            char c = s.charAt(i);
            switch (c) {
                case '[' -> reverse = ']';
                case '{' -> reverse = '}';
                case '(' -> reverse = ')';
            }
            if (reverse != 0) {
                stack.add(c);
                continue;
            }

            switch (c) {
                case ']' -> reverse = '[';
                case '}' -> reverse = '{';
                case ')' -> reverse = '(';
            }

            if (stack.isEmpty() && reverse != 0) return false;

            if (!stack.isEmpty()) {
                Character poll = stack.peekLast();
                if (poll == reverse) {
                    stack.pollLast();
                } else {
                    stack.add(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.length() == 1) return false;
        int index = 0;
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char reverse = 0;
            char c = s.charAt(i);
            switch (c) {
                case '[' -> reverse = ']';
                case '{' -> reverse = '}';
                case '(' -> reverse = ')';
            }
            if (reverse != 0) {
                chars[index++] = c;
                continue;
            }

            switch (c) {
                case ']' -> reverse = '[';
                case '}' -> reverse = '{';
                case ')' -> reverse = '(';
            }

            if (index == 0 && reverse != 0) return false;

            if (index != 0) {
                char poll = chars[index - 1];
                if (poll == reverse) {
                    chars[index--] = 0;
                } else {
                    chars[index++] = c;
                }
            }
        }

        return index == 0;
    }

    public static boolean isValidTheBest(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || stack.pop() != c) return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
