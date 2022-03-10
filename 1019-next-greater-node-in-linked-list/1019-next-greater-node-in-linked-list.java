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
    public int[] nextLargerNodes(ListNode head) {
        int[] ans = new int[size(head)];
        int index = 0;
        ListNode temp = head;
        Stack<Integer> s = new Stack<>();
        int counter = 0;
        while(temp.next != null){
            if(temp.next.val <= temp.val){
                s.push(temp.val);
                counter++;
            }else{
                ans[index] = temp.next.val;
                if(counter > 0){
                    int k = 1;
                    while(!s.isEmpty() && s.peek() < temp.next.val ){
                        if(ans[index-k] == 0)  {
                            ans[index - k] = temp.next.val;
                            counter--;
                            s.pop(); 
                        }
                        k++;                                           
                    }
                }
            }
            index++;
            temp = temp.next;
        }
        return ans;
    }
    
    static int size(ListNode head){
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;            
    }
}