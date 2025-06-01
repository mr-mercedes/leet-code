package ru.borovikov;

public class MedianOfTwoSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int numsIndex = 0;
        int leftNumsIndex = 0;
        int rightNumsIndex = 0;

        while (leftNumsIndex <= nums1.length || rightNumsIndex <= nums2.length) {
            Integer num1 = leftNumsIndex < nums1.length ? nums1[leftNumsIndex] : null;
            Integer num2 = rightNumsIndex < nums2.length ? nums2[rightNumsIndex] : null;

            if (num1 == null && num2 == null) {
                break;
            }

            if (num1 == null || num2 == null) {
                num1 = num1 == null ? Integer.MIN_VALUE : num1;
                num2 = num2 == null ? Integer.MIN_VALUE : num2;

                nums[numsIndex] = Math.max(num1, num2);
                numsIndex++;

                if (num1 > num2) {
                    leftNumsIndex++;
                } else {
                    rightNumsIndex++;
                }
                continue;
            }

            int min = Math.min(num1, num2);
            nums[numsIndex] = min;
            numsIndex++;


            if (num1 <= num2) {
                leftNumsIndex++;
                continue;
            }
            rightNumsIndex++;
        }

        return  nums.length % 2 == 0 ? (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0 : nums[nums.length / 2];
    }

    public static double findMedianSortedArraysTheBestSolution(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysTheBestSolution(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return 0;
    }
}
