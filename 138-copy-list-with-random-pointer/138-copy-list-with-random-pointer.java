/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node result = new Node(head.val);
        Node temp1 = head.next;
        head.next = result;
        result.next = temp1;
        while(temp1 != null){
            Node nextnode = temp1.next;
            Node copy = new Node(temp1.val);
            temp1.next = copy;
            copy.next = nextnode;
            temp1 = nextnode;
        }
        temp1 = head;
        Node temp2 = result;
        while(temp1 != null){
            if(temp1.random == null){
                temp2.random = temp1.random;
            }else{
                temp2.random = temp1.random.next;
            }
            
            temp1 = temp2.next;
            if(temp1 != null){
                temp2 = temp2.next.next;
            }
        }
        Node org = head;
        Node deepCopy = result;
        while(deepCopy.next != null){
            org.next = deepCopy.next;
            deepCopy.next = deepCopy.next.next;
            org = org.next;
            deepCopy = deepCopy.next;
        }
        org.next = null;
        
        
        return result;
    }
}