package ru.borovikov;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m + n - 1 - (m - 1) >= 0)
            System.arraycopy(nums2, 0, nums1, m, m + n - 1 - (m - 1));

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}