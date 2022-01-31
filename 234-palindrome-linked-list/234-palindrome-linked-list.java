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
    public boolean isPalindrome(ListNode head) {
//         if(head.next == null){
//             return true;
//         }
//         ListNode head_copy = head;
//         ListNode temp1 = head;
        
//         while(temp1.next != null){
//             ListNode temp = temp1.next;
//             temp.next = head_copy;
//             head_copy = temp;
            
//             temp1 = temp;
//         }
//         ListNode node1 = head;
//         ListNode node2 = head_copy;
//         while(node1 != null){
//             if(node1 != node2){
//                 return false;
//             }
//             node1 = node1.next;
//             node2 = node2.next;
//         }
        
//         return true;
        
        if(head==null||head.next==null) return true;
        
        Stack<Integer> st=new Stack();
        ListNode start=new ListNode(0);
        ListNode sp=start, fp=start;
        start.next=head;
        
        while(fp!=null && fp.next!=null){
            sp=sp.next;
            fp=fp.next.next;
            st.push(sp.val);
        }
        if(fp!=null) sp=sp.next;
    
        while(!st.isEmpty() && sp.val==st.peek()){
            sp=sp.next;
            st.pop();
        }      
        if(st.isEmpty()) return true;
        return false;
    }
}