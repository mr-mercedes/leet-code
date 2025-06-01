package ru.borovikov;

import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> numbers = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        List<Character> chars1 = List.of('V', 'X');
        List<Character> chars2 = List.of('L', 'C');
        List<Character> chars3 = List.of('D', 'M');

        int result = numbers.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == 'I' &&  chars1.contains(s.charAt(i + 1))) {
                result -= numbers.get(c);
                continue;
            }

            if (c == 'X' &&  chars2.contains(s.charAt(i + 1))) {
                result -= numbers.get(c);
                continue;
            }

            if (c == 'C' &&  chars3.contains(s.charAt(i + 1))) {
                result -= numbers.get(c);
                continue;
            }

            result += numbers.get(c);
        }

        return result;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> numbers = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = numbers.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            char current = s.charAt(i);
            char previous = s.charAt(i + 1);

            if (current == 'I' &&  (previous == 'V' || previous == 'X')) {
                result -= numbers.get(current);
                continue;
            }

            if (current == 'X' &&  (previous == 'L' || previous == 'C')) {
                result -= numbers.get(current);
                continue;
            }

            if (current == 'C' &&  (previous == 'D' || previous == 'M')) {
                result -= numbers.get(current);
                continue;
            }

            result += numbers.get(current);
        }

        return result;
    }

    public static int romanToIntTheBestSolve(String s) {
        final Map<Character, Integer> roman = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = roman.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int current = roman.get(s.charAt(i));
            int next = roman.get(s.charAt(i + 1));
            result += (current < next) ? -current : current;
        }

        return result;
    }

    public static int romanToIntOneMoreTheBestSolve(String s) {
        int answer = 0, current = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> current = 1000;
                case 'D' -> current = 500;
                case 'C' -> current = 100;
                case 'L' -> current = 50;
                case 'X' -> current = 10;
                case 'V' -> current = 5;
                case 'I' -> current = 1;
            }

            answer += (current < prev) ? -current : current;
            prev = current;
        }

        return answer;
    }
}
