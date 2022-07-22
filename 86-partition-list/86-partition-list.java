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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> pq = new LinkedList<>();
        ListNode temp = head;
        while(temp != null){
            q.add(temp.val);
            if(temp.val < x){
                pq.add(temp.val);
            }
            temp = temp.next;
        }
        
        ListNode head2 = null;
        boolean flag = false;
        if(!pq.isEmpty()){
            q.remove(pq.peek());
            head2 = new ListNode(pq.poll());
            temp = head2;
            flag = true;
            while(!pq.isEmpty()){
                q.remove(pq.peek());
                temp.next = new ListNode(pq.poll());
                temp = temp.next;
            }
            
            while(!q.isEmpty()){
                temp.next = new ListNode(q.poll());
                temp = temp.next;
            }
        }
        
        
        
        return flag ? head2 : head;
    }
}