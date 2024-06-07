/*
* In English, we have a concept called root, which can be followed
* by some other word to form another longer word - let's call this
* word derivative. For example, when the root "help" is followed by
* the word "ful", we can form a derivative "helpful".
* Given a dictionary consisting of many roots and a sentence
* consisting of words separated by spaces, replace all the
* derivatives in the sentence with the root forming it. If a
* derivative can be replaced by more than one root, replace it with
* the root that has the shortest length.
* Return the sentence after the replacement.
*
* Example 1:
* Input: dictionary = ["cat","bat","rat"], sentence = "the cattle
* was rattled by the battery"
* Output: "the cat was rat by the bat"
* Example 2:
* Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs
* bbab cadsfafs"
* Output: "a a b c"
*
* Constraints:
* 1 <= dictionary.length <= 1000
* 1 <= dictionary[i].length <= 100
* dictionary[i] consists of only lower-case letters.
* 1 <= sentence.length <= 10^6
* sentence consists of only lower-case letters and spaces.
* The number of words in sentence is in the range [1, 1000]
* The length of each word in sentence is in the range [1, 1000]
* Every two consecutive words in sentence will be separated by
* exactly one space.
* sentence does not have leading or trailing spaces.
*/
import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> rootSet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            result.append(prefix).append(" ");
        }

        return result.toString().trim();
    }
    public static void main(String[] args) {
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
        List<String> dictionary1 = Arrays.asList("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(sl1.replaceWords(dictionary1, sentence1)); // Output: "the cat was rat by the bat"

        List<String> dictionary2 = Arrays.asList("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(sl2.replaceWords(dictionary2, sentence2)); // Output: "a a b c"
    }
}
