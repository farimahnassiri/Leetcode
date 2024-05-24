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
