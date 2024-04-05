package recursiveSolution;

import iterativeSolution.ListNode;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * 
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * 
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * 
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class Solution {
	
    public static boolean hasCycle(ListNode head) {
        if(head == null){
           return false;
        }
        return cycleDetector(head, head.next);
    }
    private static boolean cycleDetector(ListNode node1, ListNode node2) {
        if(node2 == null || node2.next == null){
           return false;
        }

        if (node1 == node2){
            return true;
        }
        
        return cycleDetector(node1.next, node2.next.next);
    }

	public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        node4.next = node2; // To create a cycle, connect the last node to one of the previous nodes
        
        boolean hasCycle = hasCycle(node1);
        
        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }

}
