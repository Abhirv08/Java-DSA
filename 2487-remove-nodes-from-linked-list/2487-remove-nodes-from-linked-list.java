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
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();
        
        while(head != null){
            while(!dq.isEmpty() && dq.peekLast() < head.val){
                dq.removeLast();
            }
            dq.addLast(head.val);           
            
            head = head.next;
        }
        
        head = new ListNode(dq.pollFirst());
        ListNode temp = head;
        while(!dq.isEmpty()){
            int num = dq.pollFirst();
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        
        return head;
    }
}