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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode start = head;
        ListNode revPart = reverse(slow);
        ListNode end = revPart;
        int max = 0;
        
        while(end != null){
            max = Math.max(max, start.val + end.val);
            start = start.next;
            end = end.next;
        }
        
        return max;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = head;
        ListNode curr = head.next;
        if(curr == null) return head;
        prev.next = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}