
class Solution {
    private static final int MOD = 1000000007;
    private Integer[][][] memo;

    public int checkRecord(int n) {
        memo = new Integer[n + 1][2][3];
        return helper(n, 0, 0);
    }
    private int helper(int n, int cntA, int concL){
        if(n == 0){
            return 1;
        }
        if(memo[n][cntA][concL] != null){
            return memo [n][cntA][concL];
        }
        int result = 0;
        result = (result + helper(n - 1, cntA, 0)) % MOD;
        if(cntA == 0){
            result = (result + helper(n - 1, cntA + 1, 0)) % MOD;
        }
        if(concL < 2){
            result = (result + helper(n - 1, cntA, concL + 1)) % MOD;
        }
        memo[n][cntA][concL] = result;
        return result;
    }
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 1;
        int n3 = 10101;
        Solution sl1 = new Solution();
        Solution sl2 = new Solution();
        Solution sl3 = new Solution();

        int result1 = sl1.checkRecord(n1);
        int result2 = sl2.checkRecord(n2);
        int result3 = sl3.checkRecord(n3);

        System.out.println("Input: " + n1 + " Output: " + result1); // Expected Output: 8
        System.out.println("Input: " + n2 + " Output: " + result2); // Expected Output: 3
        System.out.println("Input: " + n3 + " Output: " + result3); // Expected Output: 183236316
    }
}