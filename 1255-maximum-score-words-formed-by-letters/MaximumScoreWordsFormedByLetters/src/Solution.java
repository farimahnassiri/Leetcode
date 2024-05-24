/*
* Given a list of words, list of single letters (might be repeating) 
* and score of every character. Return the maximum score of any valid 
* set of words formed by using the given letters (words[i] cannot be 
* used two or more times). It is not necessary to use all characters 
* in letters and each letter can only be used once. Score of letters 
* 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , 
* score[25] respectively.
* Example 1:
* Input: words = ["dog","cat","dad","good"], letters = 
* ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,
* 0,0,0,2,0,0,0,0,0,0,0,0,0,0]
* Output: 23
* Explanation:
* Score  a=1, c=9, d=5, g=3, o=2
* Given letters, we can form the words "dad" (5+1+5) and "good" 
* (3+2+2+5) with a score of 23.
* Words "dad" and "dog" only get a score of 21.
* Example 2:
* Input: words = ["xxxz","ax","bx","cx"], letters = 
* ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,
* 0,0,0,0,0,0,0,0,0,5,0,10]
* Output: 27
* Explanation:
* Score  a=4, b=4, c=4, x=5, z=10
* Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" 
* (4+5) with a score of 27.
* Word "xxxz" only get a score of 25.
* Example 3:
* Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], 
* score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
* Output: 0
* Explanation:
* Letter "e" can only be used once.
* Constraints:
* 1 <= words.length <= 14
* 1 <= words[i].length <= 15
* 1 <= letters.length <= 100
* letters[i].length == 1
* score.length == 26
* 0 <= score[i] <= 10
* words[i], letters[i] contains only lower case English letters.
*/

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqArray = new int[score.length];
        for(char ch : letters) {
            freqArray[ch - 'a']++;
        }
        return score(words, score, freqArray, 0);
    }

    private static int score(String[] words, int[] score, int[] freqArray, int index) {
        if(index == words.length) return 0;
        String word = words[index];
        int scoreIfWordNotIncluded = score(words, score, freqArray, index + 1);
        int scoreIfWordIncluded = 0;
        int scoreOfCurrentWord = 0;
        boolean canCurrentWordBeIncluded = true;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(freqArray[ch - 'a'] == 0) canCurrentWordBeIncluded = false;
            freqArray[ch - 'a']--;
            scoreOfCurrentWord += score[ch - 'a'];
        }
        if(canCurrentWordBeIncluded) {
            scoreIfWordIncluded = scoreOfCurrentWord + score(words, score, freqArray, index + 1);
        }
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freqArray[ch - 'a']++;
        }
        return Math.max(scoreIfWordNotIncluded, scoreIfWordIncluded);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words1 = {"dog","cat","dad","good"};
        char[] letters1 = {'a','a','c','d','d','d','g','o','o'};
        int[] score1 = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println("Example 1: " + solution.maxScoreWords(words1, letters1, score1)); // Output: 23

        String[] words2 = {"xxxz","ax","bx","cx"};
        char[] letters2 = {'z','a','b','c','x','x','x'};
        int[] score2 = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        System.out.println("Example 2: " + solution.maxScoreWords(words2, letters2, score2)); // Output: 27

        String[] words3 = {"leetcode"};
        char[] letters3 = {'l','e','t','c','o','d'};
        int[] score3 = {0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        System.out.println("Example 3: " + solution.maxScoreWords(words3, letters3, score3)); // Output: 0
    }
}
