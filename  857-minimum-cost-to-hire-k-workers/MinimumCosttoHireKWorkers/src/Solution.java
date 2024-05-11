/*
* There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.
* We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
* 1. Every worker in the paid group must be paid at least their minimum wage expectation.
* 2. In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
* Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.
* Example 1:
* Input: quality = [10,20,5], wage = [70,50,30], k = 2
* Output: 105.00000
* Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
* Example 2:
* Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
* Output: 30.66667
* Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
* Constraints:
* n == quality.length == wage.length
* 1 <= k <= n <= 104
* 1 <= quality[i], wage[i] <= 10^4
*/
import java.util.*;

class Solution {
    class WorkerRatio{
        double ratio;
        int quality;
        public WorkerRatio(double r, int q){
            ratio = r;
            quality=q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        WorkerRatio[] ratio = new WorkerRatio[n];
        for(int i=0 ; i< n ;++i) ratio[i] = new WorkerRatio((double)wage[i]/quality[i],quality[i]);
        Arrays.sort(ratio,(a,b)-> Double.compare(a.ratio,b.ratio));
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int sum=0;
        for(int i=0; i<k ; ++i){
            pq.add(ratio[i].quality);
            sum+=ratio[i].quality;
        }
        double baseRatio = ratio[k-1].ratio;
        double ans = baseRatio*sum;
        for(int i=k ; i<n ; ++i){
            double newRatio = ratio[i].ratio;
            // get k smallest quality between 0,i
            int cur_equality = ratio[i].quality;
            if(pq.peek() > cur_equality){
                sum-=pq.poll();
                pq.add(cur_equality);
                sum+=cur_equality;
            }
            ans = Math.min(ans,newRatio*sum);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] quality1 = {10, 20, 5};
        int[] wage1 = {70, 50, 30};
        int k1 = 2;
        Solution sl1 = new Solution();
        Solution sl2 = new Solution();
        System.out.println("Example 1:");
        System.out.println("Input: quality = " + Arrays.toString(quality1) + ", wage = " + Arrays.toString(wage1) + ", k = " + k1);
        System.out.println("Output: " + sl1.mincostToHireWorkers(quality1, wage1, k1));

        int[] quality2 = {3, 1, 10, 10, 1};
        int[] wage2 = {4, 8, 2, 2, 7};
        int k2 = 3;
        System.out.println("\nExample 2:");
        System.out.println("Input: quality = " + Arrays.toString(quality2) + ", wage = " + Arrays.toString(wage2) + ", k = " + k2);
        System.out.println("Output: " + sl2.mincostToHireWorkers(quality2, wage2, k2));
    }


}