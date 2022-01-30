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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode head = list1;
        if(list1.val > list2.val){
            head = list2;
            list2 = list2.next;
        }else{
            list1 = list1.next;
        }
        ListNode current_node = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current_node.next = list1;
                list1 = list1.next;
            }else{
                current_node.next = list2;
                list2 = list2.next;
            }
            current_node = current_node.next;
        }
        while(list1 != null){
            current_node.next = list1;
            list1 = list1.next;
            current_node = current_node.next;
        }
        while(list2 != null){
            current_node.next = list2;
            list2 = list2.next;
            current_node = current_node.next;
        }
        return head;
    }
}