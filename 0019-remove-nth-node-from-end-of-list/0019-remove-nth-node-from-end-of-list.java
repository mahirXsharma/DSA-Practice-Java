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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head== null || head.next == null) return null;
        ListNode temp = head;
        int sz = 0;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        int j = sz - n;
        temp = head;
        ListNode prev = null;
        if(j == 0) return head.next;
        for(int i=0; i<j; i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }
}