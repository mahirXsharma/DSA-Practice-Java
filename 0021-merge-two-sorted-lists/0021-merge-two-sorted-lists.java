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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode head1 = list1, head2 = list2;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                tail.next = head1;
                head1 = head1.next;
            }
            else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        while(head1 != null){
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }

        while(head2 != null){
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}