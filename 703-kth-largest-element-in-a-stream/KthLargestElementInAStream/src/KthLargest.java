/*
* Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
* Implement KthLargest class:
* KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
* int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
* Example 1:
* Input: ["KthLargest", "add", "add", "add", "add", "add"]
* [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
* Output: [null, 4, 5, 5, 8, 8]
* Explanation
* KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
* kthLargest.add(3);   // return 4
* kthLargest.add(5);   // return 5
* kthLargest.add(10);  // return 5
* kthLargest.add(9);   // return 8
* kthLargest.add(4);   // return 8
* Constraints:
* 1 <= k <= 10^4
* 0 <= nums.length <= 10^4
* -10^4 <= nums[i] <= 10^4
* -10^4 <= val <= 10^4
* At most 104 calls will be made to add.
* It is guaranteed that there will be at least k elements in the array when you search for the kth element.
*/

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums){
            add(n);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums1);
        System.out.println(kthLargest.add(3));  // Output: 4
        System.out.println(kthLargest.add(5));  // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9));  // Output: 8
        System.out.println(kthLargest.add(4));  // Output: 8
    }
}
