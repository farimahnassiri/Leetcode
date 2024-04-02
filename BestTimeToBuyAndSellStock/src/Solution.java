/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing 
 * a different day in the future to sell that stock.Return the maximum profit you can achieve 
 * from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * 		Input: prices = [7,1,5,3,6,4]
 * 		Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * 		Input: prices = [7,6,4,3,1]
 * 		Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Constraints:
 * 		1 <= prices.length <= 10^5
 * 		0 <= prices[i] <= 10^4
*/

public class Solution {
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0; // If prices array is null or empty, return 0 profit
		}
		
		int lowestPrice = prices[0]; // Initialize lowestPrice with first element
		int maxProfit = 0; // Initialize maxProfit as 0
		
		for (int i = 1; i < prices.length; i++) { // Start loop from second element
			if (prices[i] < lowestPrice) {
				lowestPrice = prices[i]; // Update lowestPrice if current price is lower
			} else {
				int todaysProfit = prices[i] - lowestPrice; // Calculate today's profit
				if (todaysProfit > maxProfit) {
					maxProfit = todaysProfit; // Update maxProfit if today's profit is higher
				}
			}
		}
		
		return maxProfit; // Return the maximum profit
	}
	
	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4}; // Example prices array
		int profit = maxProfit(arr); // Capture the return value
		System.out.println("Maximum profit: " + profit); // Print the maximum profit
	}

}
