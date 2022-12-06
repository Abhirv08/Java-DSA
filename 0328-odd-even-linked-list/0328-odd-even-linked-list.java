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
        ListNode oddHead = new ListNode( head.val );
        ListNode oddNode = oddHead;

        ListNode evenHead = new ListNode(head.next.val);
        ListNode evenNode = evenHead;

        ListNode temp = head;

        while(temp != null && temp.next != null){
            if(temp.next.next != null){
                oddNode.next = new ListNode(temp.next.next.val);
                oddNode = oddNode.next;
            }else{
                oddNode.next = null;
            }
            temp = temp.next.next;
        }

        temp = head.next;

        while(temp != null && temp.next != null){
            if(temp.next.next != null){
                evenNode.next = new ListNode(temp.next.next.val);
                evenNode = evenNode.next;
            }else{
                evenNode.next = null;
            }
            temp = temp.next.next;
        }

        oddNode.next = evenHead;

        return oddHead;
    }
}