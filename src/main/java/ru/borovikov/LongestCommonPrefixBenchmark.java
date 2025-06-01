package ru.borovikov;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class LongestCommonPrefixBenchmark {

    private String[] input;

    @Setup
    public void setup() {
        input = new String[]{
                "flow", "flower", "flight", "flute", "flour", "flock", "flame", "flat", "flair", "flash"
        };
    }

    @Benchmark
    public String originalVersion() {
        String prefix = input[0];
        for (int i = 1; i < input.length; i++) {
            String current = input[i];
            if (current.length() < prefix.length()) {
                prefix = prefix.substring(0, current.length());
            }
            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) != current.charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        return prefix;
    }

    @Benchmark
    public String improvedVersion() {
        if (input == null || input.length == 0) return "";
        String prefix = input[0];
        for (int i = 1; i < input.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < input[i].length() &&
                    prefix.charAt(j) == input[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
            if (prefix.isEmpty()) break;
        }
        return prefix;
    }

    @Benchmark
    public String sortedVersion() {
        String[] v = Arrays.copyOf(input, input.length);
        return LongestCommonPrefix.longestCommonPrefixAnotherSolve(v);
    }
}

