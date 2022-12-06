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

        ListNode oddHead = new ListNode(0);
        ListNode oddNode = oddHead;

        ListNode evenHead = new ListNode(0);
        ListNode evenNode = evenHead;

        ListNode temp = head;
        int count = 1;

        while(temp != null){
            if(count%2 == 1){
                oddNode.next = temp;
                oddNode = oddNode.next;
            }else{
                evenNode.next = temp;
                evenNode = evenNode.next;
            }
            count++;
            temp = temp.next;
        }

        oddHead = oddHead.next;
        evenHead = evenHead.next;
        oddNode.next = evenHead;
        evenNode.next = null;

        return oddHead;
    }
}