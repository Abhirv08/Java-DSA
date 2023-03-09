//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        int[] chars = new int[26];
        for(char ch: s.toCharArray()){
            chars[ch - 'a']++;
        }
        
        ArrayList<Node> list = new ArrayList<>();
        int[] curr = new int[26];
        int n = s.length();
        Node p1 = head, p2 = head;
        int i = 0, j = 0;
        while(p1 != null){
            curr[p1.data - 'a']++;
            if(i - j + 1 < n){
                p1 = p1.next;
                i++;
            }else{
                if(isAnagram(curr, chars)){
                    list.add(p2);
                    Node temp = p1.next;
                    p1.next= null;
                    p2 = p1 = temp;
                    i = j = 0;
                    curr = new int[26];
                }else{
                    curr[p2.data - 'a']--;
                    p2 = p2.next;
                    j++;
                    p1 = p1.next;
                    i++;
                }
            }
        }
        
        return list;
    }
    
    private static boolean isAnagram(int[] curr, int[] chars){
        for(int i = 0; i < 26; i++){
            if(curr[i] != chars[i]) return false;
        }
        
        return true;
    }
}