/*
* You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.
* For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
* Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
* Example 1: Input: arr = [1,2,3,5], k = 3, Output: [2,5]
* Explanation: The fractions to be considered in sorted order are: 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3. The third fraction is 2/5.
* Example 2: Input: arr = [1,7], k = 1, Output: [1,7]
* Constraints:
* 2 <= arr.length <= 1000
* 1 <= arr[i] <= 3 * 10^4
* arr[0] == 1
* arr[i] is a prime number for i > 0.
* All the numbers of arr are unique and sorted in strictly increasing order.
* 1 <= k <= arr.length * (arr.length - 1) / 2
* Follow up: Can you solve the problem with better than O(n2) complexity?
*/

import java.util.*;

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // Store fractions as [numerator, denominator] pairs
        List<int[]> fractions = new ArrayList<>();

        // Generate all possible fractions
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                fractions.add(new int[]{arr[i], arr[j]});
            }
        }

        // Sort fractions based on their values
        fractions.sort((a, b) -> Integer.compare(a[0] * b[1], b[0] * a[1]));

        // Return the k-th smallest fraction
        return fractions.get(k - 1);
    }
    public static void main(String[] args) {
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
        int[] arr1 = {1, 2, 3, 5};
        int k1 = 3;
        int[] result1 = sl1.kthSmallestPrimeFraction(arr1, k1);
        System.out.println("Example 1:");
        System.out.println("Input: arr = " + Arrays.toString(arr1) + ", k = " + k1 + ", Output: " + Arrays.toString(result1));

        int[] arr2 = {1, 7};
        int k2 = 1;
        int[] result2 = sl2.kthSmallestPrimeFraction(arr2, k2);
        System.out.println("Example 2:");
        System.out.println("Input: arr = " + Arrays.toString(arr2) + ", k = " + k2 + ", Output: " + Arrays.toString(result2));
    }
}
