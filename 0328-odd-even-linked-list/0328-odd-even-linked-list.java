/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null ){
            slow.next = fast.next;
            slow = fast.next;
            fast.next = slow.next;
            fast = slow.next;
            // prev.next = curr.next;
            // curr.next = null;
            // if(nh == null) {
            //     nh = curr;
            //     temp = curr;
            // }
            // else {
            //     temp.next = curr;
            //     temp = curr;
            // }
            // if(prev.next == null) break;
            // curr = prev.next.next;
            // prev = prev.next;
        }
        slow.next = newHead;
        return head;

    }
}