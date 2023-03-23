//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static Node target_node;
    static int ans;
    public static int maxDifferenceBST(Node root,int target)
    {
        target_node = null;
        ans = Integer.MIN_VALUE;
        int sum1 = findTarget(root, target);
        
        if(target_node == null) return -1;
        
        findMaxDiff(target_node, 0, sum1, target);
        
        return ans;
    }
    
    static void findMaxDiff(Node root, int currSum, int sum1, int target){
        if(root == null){
            return ;
        }
        
        if(root.left == null && root.right == null){
            currSum += root.data - target;
            ans = Math.max(ans, sum1 - currSum);
            return ;
        }
        
        findMaxDiff(root.left, currSum + root.data, sum1, target);
        findMaxDiff(root.right, currSum + root.data, sum1, target);
    }
    
    static int findTarget(Node root, int target){
        if(root == null) return 0;
        
        if(root.data == target){
            target_node = root;
            return 0;
        }
        
        if(root.data < target){
            return root.data + findTarget(root.right, target);
        }
        
        return root.data + findTarget(root.left, target);
    }
}