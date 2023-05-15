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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode f = null;
        ListNode l = null;
        
        ListNode temp = head;
        
        int len = getLength(head);
        
        int count = 1;
        while(temp != null){
            if(count == k){
                f = temp;
            }
            
            if(count == len - k + 1){
                l = temp;
            }
            
            count++;
            temp = temp.next;
        }
        
        if(f == l) return head;
        
        System.out.println(f.val + ":" + l.val);
        
        int t_v = f.val;
        f.val = l.val;
        l.val = t_v;
        
        return head;
        
    }
    
    private int getLength(ListNode head){
        int len = 0;
        
        ListNode temp = head;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        return len;
    }
}