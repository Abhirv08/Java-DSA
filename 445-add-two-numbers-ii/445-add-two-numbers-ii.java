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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = reverse(l1);
        ListNode q = reverse(l2);
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        int carry = 0;
        while( p != null || q != null ){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            temp.next = new ListNode( sum%10 );
            temp = temp.next;
            
            if(p != null) p = p.next;
            if(q != null) q = q.next;
            
        }
        if(carry!=0) temp.next = new ListNode(carry);
        return reverse(ans.next);
        
    }
    
    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;         
        ListNode next_node = null;
        while(curr != null){            
            next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        return prev;
    }
}