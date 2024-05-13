class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length; // the row
        int m = grid[0].length; // the column
        int res = (1 << (m - 1)) * n;

        for(int j = 1; j < m ; ++j){
            int val = 1 << (m - 1 - j);
            int set = 0;

            for(int i = 0; i < n; ++i){
                if (grid[i][j] == grid[i][0]) {
                    set++;
                }
            }
            res += Math.max(set, n - set) * val;
        }
        return res;
    }
    public static void main(String[] args) {
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
        int[][] grid1 = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int[][] grid2 = {{0}};
        
        System.out.println("Output for grid1: " + sl1.matrixScore(grid1));
        System.out.println("Output for grid2: " + sl2.matrixScore(grid2));
    }
}