/*
* Alice has some number of cards and she wants to rearrange the cards into groups so that each group
* is of size groupSize, and consists of groupSize consecutive cards.
* Given an integer array hand where hand[i] is the value written on the ith card and an integer
* groupSize, return true if she can rearrange the cards, or false otherwise.
*
* Example 1:
* Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
* Output: true
* Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
* Example 2:
* Input: hand = [1,2,3,4,5], groupSize = 4
* Output: false
* Explanation: Alice's hand can not be rearranged into groups of 4.
*
* Constraints:
* 1 <= hand.length <= 10^4
* 0 <= hand[i] <= 10^9
* 1 <= groupSize <= hand.length
*/


import java.util.*;

public class Solution {
	   public boolean isNStraightHand(int[] hand, int groupSize) {
	        if (hand.length % groupSize != 0) {
	            return false;
	        }

	        Map<Integer, Integer> freq = new HashMap<>();

	        for (int card: hand) {
	            freq.put(card, freq.getOrDefault(card, 0) + 1);
	        }

	        Arrays.sort(hand);

	        for (int i = 0; i < hand.length; i++) {
	            if (freq.get(hand[i]) == 0) {
	                continue;
	            }

	            for (int j = 0; j < groupSize; j++) {
	                int currCard = hand[i] + j;
	                if (freq.getOrDefault(currCard, 0) == 0) {
	                    return false;
	                }

	                freq.put(currCard, freq.get(currCard) - 1);
	            }
	        }

	        return true;
	    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize1 = 3;
        System.out.println(solution.isNStraightHand(hand1, groupSize1));  // Output: true

        // Test case 2
        int[] hand2 = {1, 2, 3, 4, 5};
        int groupSize2 = 4;
        System.out.println(solution.isNStraightHand(hand2, groupSize2));  // Output: false
    }
}
