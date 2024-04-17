/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"

Constraints:

1 <= num1.length, num2.length <= 10^4
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
*/
class Solution {
    public String addStrings(String num1, String num2) {
       int i = num1.length() - 1;
       int j = num2.length() - 1;
       int sum, carry = 0;
       StringBuilder str = new StringBuilder();

       while(i >= 0 || j >=0 ){
            sum = carry;

            if(i >= 0){
                sum += (int) num1.charAt(i) - 48;
                i--;
            }
            if(j >= 0){
                sum += (int) num2.charAt(j) - 48;
                j--;
            }
            carry = sum / 10;
            sum = sum % 10;
            str.append(sum);        
       }

       if(carry == 1){
            carry = 0;
            str.append(1);
       }
        str = str.reverse();
        return str.toString();

    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test example 1
        String num1 = "11";
        String num2 = "123";
        System.out.println("Input: num1 = \"" + num1 + "\", num2 = \"" + num2 + "\"");
        System.out.println("Output: " + solution.addStrings(num1, num2)); // Output: "134"
        
        // Test example 2
        num1 = "456";
        num2 = "77";
        System.out.println("Input: num1 = \"" + num1 + "\", num2 = \"" + num2 + "\"");
        System.out.println("Output: " + solution.addStrings(num1, num2)); // Output: "533"
        
        // Test example 3
        num1 = "0";
        num2 = "0";
        System.out.println("Input: num1 = \"" + num1 + "\", num2 = \"" + num2 + "\"");
        System.out.println("Output: " + solution.addStrings(num1, num2)); // Output: "0"
    }
}
