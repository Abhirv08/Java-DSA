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
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode oddHead = head;

        ListNode evenHead = head.next;
        ListNode evenNode = evenHead;

        ListNode temp = evenHead.next;
        oddHead.next = temp;

        while(temp != null && temp.next != null){
            evenNode.next = temp.next;
            evenNode = evenNode.next;
            temp.next = evenNode.next;
            temp = temp.next;
        }

        evenNode.next = null;

        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = evenHead;

        return oddHead;
    }
}