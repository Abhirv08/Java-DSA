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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null, next_node = null;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode list2_end = null;
        while(temp2 != null){            
            list2_end = temp2;
            temp2 = temp2.next;
        }
        int counter = 0;
        while(counter != b+1){
            if(counter==a-1){
                prev = temp1;
            }            
            temp1 = temp1.next;
            counter++;
        }
        next_node = temp1;
        prev.next = list2;
        list2_end.next = next_node;
        
        return list1;
    }
}