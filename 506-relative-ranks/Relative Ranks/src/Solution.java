import java.util.*;
/*
* You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
* The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
* The 1st place athlete's rank is "Gold Medal".
* The 2nd place athlete's rank is "Silver Medal".
* The 3rd place athlete's rank is "Bronze Medal".
* For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
* Return an array answer of size n where answer[i] is the rank of the ith athlete.
* Example 1:
* Input: score = [5,4,3,2,1]
* Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
* Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
* Example 2:
* Input: score = [10,3,8,9,4]
* Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
* Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
* Constraints:
* n == score.length
* 1 <= n <= 10^4
* 0 <= score[i] <= 10^6
* All the values in score are unique.
*/

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sortedScores = Arrays.copyOf(score, score.length);
        Arrays.sort(sortedScores);
        reverse(sortedScores);

        Map<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < Math.min(score.length, 3); i++) {
            int rank = i + 1;
            switch (rank) {
                case 1:
                    rankMap.put(sortedScores[i], "Gold Medal");
                    break;
                case 2:
                    rankMap.put(sortedScores[i], "Silver Medal");
                    break;
                case 3:
                    rankMap.put(sortedScores[i], "Bronze Medal");
                    break;
            }
        }
        for (int i = 3; i < score.length; i++) {
            rankMap.put(sortedScores[i], String.valueOf(i + 1));
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = rankMap.get(score[i]);
        }
        return result;
    }
    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Solution sl1 = new Solution();
        Solution sl2 = new Solution();
        // Example 1
        int[] score1 = {5, 4, 3, 2, 1};
        String[] result1 = sl1.findRelativeRanks(score1);
        System.out.println("Example 1:");
        System.out.println("Input: score = " + Arrays.toString(score1));
        System.out.println("Output: " + Arrays.toString(result1));
        
        // Example 2
        int[] score2 = {10, 3, 8, 9, 4};
        String[] result2 = sl2.findRelativeRanks(score2);
        System.out.println("\nExample 2:");
        System.out.println("Input: score = " + Arrays.toString(score2));
        System.out.println("Output: " + Arrays.toString(result2));
    }
}