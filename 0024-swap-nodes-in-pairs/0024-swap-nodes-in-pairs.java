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
        
        ListNode prev = null;
        while(temp != null){
            ListNode cur = temp;
            ListNode next = temp.next;
            
            if(next == null) return head;
            if(prev == null){
                cur.next = next.next;
                next.next = cur;
                head = next;
            }else{
                prev.next = next;
                cur.next = next.next;
                next.next = cur;
            }            
            prev = cur;
            temp = cur.next;
        }
        
        return head;
    }
}