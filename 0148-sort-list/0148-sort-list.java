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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        ListNode temp = head;
        while(temp != null){
            pq.add(temp);
            temp = temp.next;
        }
        ListNode newHead = pq.remove(); 
        temp = newHead;
        while(!pq.isEmpty()){
           ListNode curr = pq.remove();
            temp.next = curr;
            temp = curr;
        }
        temp.next = null;
        return newHead;
    }
}