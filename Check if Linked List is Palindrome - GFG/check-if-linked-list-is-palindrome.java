//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        Node slow = head, fast = head;
        int nodes = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            nodes += 2;
        }
        
        if(fast != null) nodes++;
        if(nodes == 1) return true;
        if(nodes == 2){
            return head.data == head.next.data;
        }
        
        Node part2 = null;
        if(nodes%2 == 0){
            part2 = reverseList(slow);
        }else{
            part2 = reverseList(slow.next);
        }
       
        slow.next = null;
        
        
        
        return checkPalindrome(head, part2);
    }
    
    private void print(Node head){
        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    
    private boolean checkPalindrome(Node part1, Node part2){
        while(part2 != null && part1 != null){
            if(part1.data != part2.data) return false;
            part1 = part1.next;
            part2 = part2.next;
        }
        
        return true;
    }
    
    private Node reverseList(Node head){
        if(head == null) return null;
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr != null) next = curr.next;
        }
        
        return prev;
    }
}

