/*
* There are n kids with candies. You are given an integer array candies, 
* where each candies[i] represents the number of candies the ith kid has, 
* and an integer extraCandies, denoting the number of extra candies that 
* you have. Return a boolean array result of length n, where result[i] is 
* true if, after giving the ith kid all the extraCandies, they will have 
* the greatest number of candies among all the kids, or false otherwise.
* Note that multiple kids can have the greatest number of candies.
* Example 1:
* Input: candies = [2,3,5,1,3], extraCandies = 3
* Output: [true,true,true,false,true]
* Explanation: If you give all extraCandies to:
* - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among 
* the kids.
* - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among 
* the kids.
* - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among 
* the kids.
* - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest 
* among the kids.
* - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among 
* the kids.
* Example 2:
* Input: candies = [4,2,1,1,2], extraCandies = 1
* Output: [true,false,false,false,false]
* Explanation: There is only 1 extra candy.
* Kid 1 will always have the greatest number of candies, even if a 
* different kid is given the extra candy.
* Example 3:
* Input: candies = [12,1,12], extraCandies = 10
* Output: [true,false,true]
* Constraints:
* n == candies.length
* 2 <= n <= 100
* 1 <= candies[i] <= 100
* 1 <= extraCandies <= 50
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        boolean flag = true;
        for(int i = 0; i < candies.length; i++){
            for(int j = 0; j < candies.length; j++){
                if(candies[i] + extraCandies < candies[j]){
                    flag = flag && false;
                }
            }
            ans.add(flag);
            flag = true;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        System.out.println("Example 1:");
        System.out.println("Input: candies = [2, 3, 5, 1, 3], extraCandies = 3");
        System.out.println("Output: " + solution.kidsWithCandies(candies1, extraCandies1));

        // Example 2
        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        System.out.println("Example 2:");
        System.out.println("Input: candies = [4, 2, 1, 1, 2], extraCandies = 1");
        System.out.println("Output: " + solution.kidsWithCandies(candies2, extraCandies2));

        // Example 3
        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        System.out.println("Example 3:");
        System.out.println("Input: candies = [12, 1, 12], extraCandies = 10");
        System.out.println("Output: " + solution.kidsWithCandies(candies3, extraCandies3));
    }
}
