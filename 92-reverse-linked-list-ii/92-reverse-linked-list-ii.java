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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || (right-left)== 0){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        if(left==1){
            while(left < right){
                ListNode nextNode = curr.next;
                curr.next = nextNode.next;
                nextNode.next = head;
                head = nextNode;
                left++;
            }
            return head;
        }
        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        while(left < right){
            ListNode nextNode = curr.next;
            curr.next = curr.next.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            left++;
        }
        return head;
    }
}