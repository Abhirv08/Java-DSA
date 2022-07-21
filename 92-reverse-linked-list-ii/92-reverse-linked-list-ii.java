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
        if(head == null || left == right){
            return head;
        }
        
        ListNode prev = null, curr = head, ahead = head.next;
        ListNode leftNode = null, rightNode = null;
        ListNode leftJoining = null, rightJoining = null;
        int nodeNo = 1;
        while(curr != null){
            if(leftNode == null && nodeNo != left){
                prev = curr;
                curr = ahead;
                if(ahead != null){
                    ahead = ahead.next;
                }
                nodeNo++;
                continue;
            }else if (leftNode == null && nodeNo == left){
                leftJoining = prev;
                leftNode = curr;
            }else if(leftNode != null && rightNode == null){
                curr.next = prev;
                if(nodeNo == right){
                    rightJoining = ahead;
                    rightNode = curr;
                    break;
                }
            }            
            prev = curr;
            curr = ahead;
            if(ahead != null){
                ahead = ahead.next;
            }
            nodeNo++;
        }
        
        if(leftJoining != null && rightJoining != null){
            leftJoining.next = rightNode;
            leftNode.next = rightJoining;
        }else if(leftJoining == null && rightJoining != null){
            leftNode.next = ahead;
            head = curr;
        }else if(leftJoining != null && rightJoining == null){
            leftJoining.next = rightNode;
            leftNode.next = null;
        }else{
            head = curr;
            leftNode.next = null;
        }
        
        return head;
    }
}