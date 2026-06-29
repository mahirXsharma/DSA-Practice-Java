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
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode newHead = mergeSort(head, temp);
        return newHead;
    }

    public ListNode mergeSort(ListNode head,ListNode tail){
        if(head == tail) return head;
        ListNode mid = midFinder(head, tail);
        // we have to save the mid.next;
        ListNode save = mid.next;
        mid.next = null;
        ListNode leftHead = mergeSort(head, mid);
        ListNode rightHead = mergeSort(save, tail);
        // finding tail of left
        return merge(leftHead, rightHead);
    }

    public ListNode merge(ListNode lh, ListNode rh){
        ListNode head;
        if(lh.val > rh.val){
            head = rh;
            rh = rh.next;
        } 
        else {
            head = lh;
            lh = lh.next;
        }
        ListNode temp = head;
        while(lh != null && rh != null){
            if(lh.val > rh.val){
                temp.next = rh;
                temp = rh;
                rh = rh.next;
            }
            else {
                temp.next = lh;
                temp = lh;
                lh = lh.next;
            }
        }
        while(lh != null){
            temp.next = lh;
            temp = lh;
            lh = lh.next;
        }
        while(rh != null){
            temp.next = rh;
            temp = rh;
            rh = rh.next;
        }
        return head;
    }

    public ListNode midFinder(ListNode head, ListNode tail){
        
        ListNode slow =  head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}