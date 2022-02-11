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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode prev = null, curr = head;
        boolean duplicate = false;
        while(temp != null){
            if(curr.val==temp.val){
                duplicate = true;
                temp = temp.next;                
            }else{
                if(duplicate){   
                    if(curr==head){
                        head = temp;
                    }
                    if(prev != null) prev.next = temp;
                    curr = temp;
                    temp = temp.next;
                    duplicate = false;
                    
                }else{
                    prev = curr;
                    curr = temp;
                    temp = temp.next;
                    }
                
            }
        }
        if(duplicate){
            if( curr == head)  return null;
            else {
                prev.next = null;
            }
        }
        return head;
    }
}