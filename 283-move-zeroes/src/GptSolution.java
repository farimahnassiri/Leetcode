
public class GptSolution {
	public void moveZeroes(int[] nums) {
	int zeroIndex = 0;        
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
	        // Swap non-zero element with the first zero element encountered
				int temp = nums[zeroIndex];
	            nums[zeroIndex] = nums[i];
	            nums[i] = temp;
	            zeroIndex++;
	        }
	    }
	}
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums1);
        printArray(nums1);

        // Example 2
        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        printArray(nums2);
    }

    // Printer method
    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
