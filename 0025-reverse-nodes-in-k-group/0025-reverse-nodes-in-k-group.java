public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy; 
        ListNode curr = head;      

        while (length >= k) {
            ListNode prev = null;
            
            for (int i = 0; i < k; i++) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            ListNode tail = groupPrev.next; 
            
            tail.next = curr; 
            groupPrev.next = prev; 
            
            groupPrev = tail; 

            length -= k; 
        }

        return dummy.next;
    }
}