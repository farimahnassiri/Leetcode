/*
* Given a string s and a dictionary of strings wordDict, add spaces in s to
* construct a sentence where each word is a valid dictionary word. Return all
* such possible sentences in any order. Note that the same word in the 
* dictionary may be reused multiple times in the segmentation.
* 
* Example 1:
* Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
* Output: ["cats and dog","cat sand dog"]
* Example 2:
* Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
* "pineapple"]
* Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
* Explanation: Note that you are allowed to reuse a dictionary word.
* Example 3:
* Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
* Output: []
* 
* Constraints:
* 1 <= s.length <= 20
* 1 <= wordDict.length <= 1000
* 1 <= wordDict[i].length <= 10
* s and wordDict[i] consist of only lowercase English letters.
* All the strings of wordDict are unique.
* Input is generated in a way that the length of the answer doesn't exceed 10^5.
*/
import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordDict);
        return findWord(s, 0, set, map);
    }

    private List<String> findWord(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> hm){
        if(hm.containsKey(start)){
            return hm.get(start);
        }
        List<String> validSubstr = new ArrayList<>();

        if(start == s.length()){
            validSubstr.add("");
        }
        for(int end = start + 1; end <= s.length(); end++){
            String prefix = s.substring(start, end);
            if(dict.contains(prefix)){
                List<String> suffixes = findWord(s, end, dict, hm);
                for(String suffix : suffixes){
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }
        hm.put(start, validSubstr);
        return validSubstr;
    }
    public static void main(String[] args) {
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
    	Solution sl3 = new Solution();
        // Example 1
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result1 = sl1.wordBreak(s1, wordDict1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> result2 = sl2.wordBreak(s2, wordDict2);
        System.out.println("Example 2 Output: " + result2);

        // Example 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> result3 = sl3.wordBreak(s3, wordDict3);
        System.out.println("Example 3 Output: " + result3);
    }

}