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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int size = length(head);
        k = k%size;
        if(k == 0) return head;
        ListNode temp = head;
        ListNode tail = null;
        ListNode cutpoint = null;
        int counter = 1;
        while( temp != null){
            if(counter == size-k){
                cutpoint = temp;
            }
            tail = temp;
            counter++;
            temp = temp.next;
        }
        tail.next = head;
        head = cutpoint.next;
        cutpoint.next = null;
        return head;
    }
    
    static int length(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    
}