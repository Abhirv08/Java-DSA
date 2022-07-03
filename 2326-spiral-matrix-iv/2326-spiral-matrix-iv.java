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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int[] mat : matrix){
            Arrays.fill(mat, -1);
        }
        
        int rowStart = 0;
        int rowEnd = m-1;
        int colStart = 0;
        int colEnd = n-1;
        
        ListNode temp = head;
        while(temp != null){
            for(int col = colStart; temp != null && col <= colEnd; col++){
                matrix[rowStart][col] = temp.val;
                temp = temp.next;
                if(col == colEnd){
                    rowStart++;
                }
            }
            
            for(int row = rowStart; temp != null && row <= rowEnd; row++){
                matrix[row][colEnd] = temp.val;
                temp = temp.next;
                if(row == rowEnd){
                    colEnd--;
                }
            }
            
            for(int col = colEnd; temp != null && col >= colStart; col--){
                matrix[rowEnd][col] = temp.val;
                temp = temp.next;
                if(col == colStart){
                    rowEnd--;
                }
            }
            
            for(int row = rowEnd; temp != null && row >= rowStart; row--){
                matrix[row][colStart] = temp.val;
                temp = temp.next;
                if(row == rowStart){
                    colStart++;
                }
            }            
        }
        
        
        return matrix;
    }
}