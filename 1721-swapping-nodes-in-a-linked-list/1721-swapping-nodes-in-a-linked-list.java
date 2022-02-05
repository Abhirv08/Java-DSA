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
    public ListNode swapNodes(ListNode head, int n) {
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size==2){
            ListNode temp2 = head.next;
            temp2.next = head;
            head.next = null;
            head = temp2;
            return head;
        }
        int first = n-1;
        int second = size-n; 
        if(first > second){
            int temp3 = first;
            first = second;
            second =temp3;
        }
        if(first==0){            
            ListNode p2 = head;
                while(second > 1){
                p2 = p2.next;
                second--;
            }
            ListNode firstNumToBeSwapped = head;
            ListNode secondNumToBeSwapped = p2.next;
            p2.next = firstNumToBeSwapped;
            secondNumToBeSwapped.next = firstNumToBeSwapped.next;
            firstNumToBeSwapped.next = null;
            head = secondNumToBeSwapped;
            
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(first > 1 && second > 1){
            p1 = p1.next;  
            p2= p2.next;
            first--;
            second--;
        }
        while(second > 1){
            p2 = p2.next;
            second--;
        }
        if(p1==p2) return head;
        ListNode firstNumToBeSwapped = p1.next;
        ListNode secondNumToBeSwapped = p2.next;
        p1.next = secondNumToBeSwapped;        
        p2.next = firstNumToBeSwapped;
        temp = firstNumToBeSwapped.next;
        firstNumToBeSwapped.next = secondNumToBeSwapped.next;        
        secondNumToBeSwapped.next = temp;;
        return head;
    }
}