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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        
        return makeTree(list, 0, list.size() - 1);
    }
    
    private TreeNode makeTree(List<Integer> list, int l, int r){
        if(r < l) return null;
        if(l == r) return new TreeNode(list.get(l));
        
        int m = l + ( r - l)/2;
        
        TreeNode root = new TreeNode(list.get(m));
        
        root.left = makeTree(list, l, m - 1);
        root.right = makeTree(list, m+1, r);
        
        return root;
    }
}