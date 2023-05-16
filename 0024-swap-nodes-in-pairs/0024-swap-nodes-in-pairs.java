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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        ListNode next = temp.next;
        
        if(next == null) return head;
        
        ListNode doubleNext = next.next;
        next.next = temp;
        head = next;        
        temp.next = swapPairs(doubleNext);
        
        return next;
    }
}