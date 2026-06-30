public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int szA = 0;
        int szB = 0;

        // 1. Find the lengths of both tracks
        while (tempA != null) {
            szA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            szB++;
            tempB = tempB.next;
        }

        // 2. Calculate the difference
        int ahead = Math.abs(szA - szB);

        // 3. Reset the runners back to the starting lines
        tempA = headA;
        tempB = headB;

        // 4. Give the longer track the head start
        if (szA > szB) {
            for (int i = 0; i < ahead; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 0; i < ahead; i++) {
                tempB = tempB.next;
            }
        }

        // 5. Fire the gun! They are now physically aligned.
        // Step forward together until the remotes point to the exact same box.
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        // If they intersect, tempA holds that node.
        // If they don't intersect, both will hit 'null' at the exact same time!
        return tempA;
    }
}