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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = lists[0];
        
        for(int i = 1; i < lists.length; i++){
            head = merge(head, lists[i]);
        }
        
        return head;
    }
    
    ListNode merge(ListNode head, ListNode list2){
        if(head == null) return list2;        
        if(list2 == null) return head;
        
        if(head.val > list2.val){
            ListNode temp = head;
            head = list2;
            list2 = temp;
        }
        
        ListNode temp1 = head;
        ListNode temp2 = list2;
        ListNode next1 = temp1.next, next2 = temp2.next;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                if(next1 == null || temp2.val <= next1.val){
                    temp1.next = temp2;
                    temp2.next = next1;
                    temp2 = next2;
                }else{
                    temp1 = temp1.next;
                }
            }
            if(temp1 != null) next1 = temp1.next;
            if(temp2 != null) next2 = temp2.next;
        }
        
        return head;
    }
    
}