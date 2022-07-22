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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head;
        
        ListNode bf_head = new ListNode(0);
        ListNode before = bf_head;
        
        ListNode af_head = new ListNode(0);
        ListNode after = af_head;
        
        while(temp != null){
            if(temp.val < x){
                before.next = temp;
                before = before.next;
            }else{
                after.next = temp;
                after = after.next;
            }
            
            temp = temp.next;
        }
        
        before.next = af_head.next;
        after.next = null;
        
        return bf_head.next;
    }
}