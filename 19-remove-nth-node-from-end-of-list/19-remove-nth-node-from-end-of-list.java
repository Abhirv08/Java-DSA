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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(k > 0){
            fast = fast.next;
            k--;
        }
        
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        if(fast == null){
            return head.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
        
    }
}