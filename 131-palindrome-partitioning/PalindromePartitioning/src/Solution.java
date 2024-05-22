/*
* Given a string s, partition s such that every
* substring of the partition is a palindrome.
* Return all possible palindrome partitioning of s.
* Example 1:
* Input: s = "aab", Output: [["a","a","b"],["aa","b"]]
* Example 2:
* Input: s = "a", Output: [["a"]]
* Constraints:
* 1 <= s.length <= 16
* s contains only lowercase English letters.
*/
import java.util.*;

class Solution {
    private boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end = start + 1; end <= s.length(); end++){
            String currentSub = s.substring(start, end);
            if(isPalindrome(currentSub)){
                path.add(currentSub);
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        printResult(result);
    }

    private static void printResult(List<List<String>> result) {
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}