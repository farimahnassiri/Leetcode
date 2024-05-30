/*
* Given an array of integers arr.
* We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
* Let's define a and b as follows:
* a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
* b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
* Note that ^ denotes the bitwise-xor operation.
* Return the number of triplets (i, j and k) Where a == b.
* 
* Example 1:
* Input: arr = [2,3,1,6,7], Output: 4
* Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
* Example 2:
* Input: arr = [1,1,1,1,1], Output: 10
* 
* Constraints:
* 1 <= arr.length <= 300
* 1 <= arr[i] <= 10^8
*/

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int count = 0;
        for(int i =0; i < n; i++){
            for(int k = i +1; k < n;k++){
                if(prefix[i] == prefix[k + 1]){
                    count += (k - i);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
        int[] arr1 = {2, 3, 1, 6, 7};
        int[] arr2 = {1, 1, 1, 1, 1};
        
        System.out.println("Test Case 1: " + sl1.countTriplets(arr1)); // Expected output: 4
        System.out.println("Test Case 2: " + sl2.countTriplets(arr2)); // Expected output: 10
    }
}