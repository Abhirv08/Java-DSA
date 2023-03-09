/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        
        HashMap<ListNode, Integer> map = new HashMap<>();
        
        ListNode temp = head;
        int i = 0;
        while(true){
            
            if(map.containsKey(temp)){                
                break;
            }else{
                map.put(temp, i++);
                temp = temp.next;
            }
        }
        
        return temp;
    }
}