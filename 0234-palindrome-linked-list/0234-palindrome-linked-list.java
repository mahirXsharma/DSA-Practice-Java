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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head , fast = head, prev = null, left = head;
        while(fast != null && fast.next != null){
            left = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        left.next = null;
        ListNode next;
        while(slow != null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // now compare between prev and head
        while(prev != null && head != null){
            if(prev.val != head.val) return false; 
            prev = prev.next;
            head = head.next;
        }
        return true;
        
    }
}