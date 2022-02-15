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
    public ListNode deleteMiddle(ListNode head) {
               
        
        if(head.next == null) return null;
        ListNode temp = head;
        int middle = size(head)/2;
        int counter = 0;
        ListNode prev= null, nextNode = null;
        while(counter <= middle){
            if(counter==middle-1){prev = temp;}
            temp = temp.next;            
            counter++;
        }
        nextNode = temp;
        prev.next = nextNode;
        return head;
    }
    
    static int size(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}