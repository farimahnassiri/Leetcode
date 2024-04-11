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

public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int bits = 0;
        for(int i = 1; i <= 32; i++) {
            bits += (n & mask) == 0 ? 0 : 1;
            mask <<= 1;
        }
        return bits;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 sl2 = new Solution2();
		int result = sl2.hammingWeight(12);
		
		System.out.print(result);
	}
}
