package ru.borovikov;


public class Main {
    public static void main(String[] args) {
//        String[] arr = {"flower","flow","flight"};
//        String[] arr = {"dog","racecar","car"};
//        String[] arr = {"ab","a"};
        String[] arr = {"reflower","flow","flight"};
        String s = LongestCommonPrefix.longestCommonPrefix(arr);
        System.out.println(s);
    }

}

