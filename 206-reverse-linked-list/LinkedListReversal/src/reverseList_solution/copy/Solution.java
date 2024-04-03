package reverseList_solution.copy;

import recursive_solution.ListNode;

/*
 *  Given the head of a singly linked list, reverse the list, and return the reversed list.
 *  Example 1. Input: head = [1,2,3,4,5], Output: [5,4,3,2,1]
 *  Example 2. Input: head = [1,2], Output: [2,1]
 *  Example 3. Input: head = [], Output: []
 */

class Solution {
    public ListNode reverseList(ListNode head) {
    ListNode currentNode = head, previousNode = null, nextNode = null;

        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
    
    public static void main(String[] args) {
        // Example 1: [1, 2, 3, 4, 5]
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        Solution sl = new Solution();
        
        printList("Original list (Example 1):", head1);
        ListNode reversedHead1 = sl.reverseList(head1);
        printList("Reversed list (Example 1):", reversedHead1);

        // Example 2: [1, 2]
        ListNode head2 = createLinkedList(new int[]{1, 2});
        printList("Original list (Example 2):", head2);
        ListNode reversedHead2 = sl.reverseList(head2);
        printList("Reversed list (Example 2):", reversedHead2);

        // Example 3: []
        ListNode head3 = null;
        printList("Original list (Example 3):", head3);
        ListNode reversedHead3 = sl.reverseList(head3);
        printList("Reversed list (Example 3):", reversedHead3);
    }

    // Method to create a linked list from an array of integers
    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Method to print a linked list
    private static void printList(String message, ListNode head) {
        System.out.print(message + " ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
