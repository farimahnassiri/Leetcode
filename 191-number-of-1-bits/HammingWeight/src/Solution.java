/*
Write a function that takes the binary representation of a positive integer and returns the number of set bits
it has (also known as the Hamming weight).

Example 1:
Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.

Example 2:
Input: n = 128
Output: 1
Explanation:
The input binary string 10000000 has a total of one set bit.

Example 3:
Input: n = 2147483645
Output: 30
Explanation:
The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
*/

public class Solution {

	public int hammingWeight(int n) {
        int num = n;
        String binaryString = "";
        //need to find the binary version of n
        // 2^0 * (0 || 1) + 2^1  * (0 || 1) + 2^2  * (0 || 1) + ...
        if (n == 0 || n == 1){
            return n;
        }

        while(num != 0){
            if(num % 2 == 1){
                binaryString += "1";
            } 
            if(num % 2 == 0){
                binaryString += "0";
            }
            num = num / 2;
        }
        // this implementation will return the binary number in reverse
        char [] binaryStringArr = binaryString.toCharArray();
        int counter = 0;
        for(int i = 0; i < binaryStringArr.length ; i++){
            if(binaryStringArr[i] == '1'){
                counter ++;
            }
        }
        return counter;
        // process to see how many 1's in the binary
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sl = new Solution();
		int result = sl.hammingWeight(12);
		
		System.out.print(result);
	}

}
