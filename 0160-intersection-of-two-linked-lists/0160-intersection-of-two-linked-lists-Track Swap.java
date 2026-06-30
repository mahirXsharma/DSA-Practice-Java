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
        ListNode tempA = headA;
        ListNode tempB = headB;
        int szA = 0;
        int szB = 0;

        while (tempA != null) {
            szA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            szB++;
            tempB = tempB.next;
        }

        int ahead = Math.abs(szA - szB);

        tempA = headA;
        tempB = headB;

        if (szA > szB) {
            for (int i = 0; i < ahead; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 0; i < ahead; i++) {
                tempB = tempB.next;
            }
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}