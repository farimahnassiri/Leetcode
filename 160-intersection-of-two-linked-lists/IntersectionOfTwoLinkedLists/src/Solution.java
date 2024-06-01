/**
* Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
* If the two linked lists have no intersection at all, return null. For example, the following two linked lists 
* begin to intersect at node c1: The test cases are generated such that there are no cycles anywhere in the entire 
* linked structure. Note that the linked lists must retain their original structure after the function returns.
* Custom Judge: The inputs to the judge are given as follows (your program is not given these inputs):
* intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
* listA - The first linked list.
* listB - The second linked list.
* skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
* skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
* The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to 
* your program. If you correctly return the intersected node, then your solution will be accepted.
* Example 1:
* Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3, Output: Intersected at '8'
* Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
* From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before 
* the intersected node in A; There are 3 nodes before the intersected node in B.
* Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd 
* node in B) are different node references. In other words, they point to two different locations in memory, while 
* the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
* Example 2:
* Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1, Output: Intersected at '2'
* Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
* From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the 
* intersected node in A; There are 1 node before the intersected node in B.
* Example 3:
* Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2, Output: No intersection
* Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists 
* do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values. Explanation: The two lists 
* do not intersect, so return null.
* Constraints:
* The number of nodes of listA is in the m.
* The number of nodes of listB is in the n.
* 1 <= m, n <= 3 * 10^4
* 1 <= Node.val <= 10^5
* 0 <= skipA < m
* 0 <= skipB < n
* intersectVal is 0 if listA and listB do not intersect.
* intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
* Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }
            else{
                p1 = p1.next;
            }
            if(p2 == null){
                p2 = headA;
            }
            else{
                p2 = p2.next;
            }
        }
        return p1;
    }

    public void printIntersectionNode(ListNode intersectionNode) {
        if (intersectionNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersected at '" + intersectionNode.val + "'");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case 1
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);

        a1.next = a2; a2.next = c1; c1.next = c2; c2.next = c3;
        b1.next = b2; b2.next = b3; b3.next = c1;

        ListNode intersectionNode1 = solution.getIntersectionNode(a1, b1);
        solution.printIntersectionNode(intersectionNode1);

        // Example test case 2
        ListNode d1 = new ListNode(1);
        ListNode d2 = new ListNode(9);
        ListNode d3 = new ListNode(1);
        ListNode e1 = new ListNode(3);
        ListNode f1 = new ListNode(2);
        ListNode f2 = new ListNode(4);

        d1.next = d2; d2.next = d3; d3.next = f1; f1.next = f2;
        e1.next = f1;

        ListNode intersectionNode2 = solution.getIntersectionNode(d1, e1);
        solution.printIntersectionNode(intersectionNode2);

        // Example test case 3
        ListNode g1 = new ListNode(2);
        ListNode g2 = new ListNode(6);
        ListNode g3 = new ListNode(4);
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(5);

        g1.next = g2; g2.next = g3;
        h1.next = h2;

        ListNode intersectionNode3 = solution.getIntersectionNode(g1, h1);
        solution.printIntersectionNode(intersectionNode3);
    }
}
