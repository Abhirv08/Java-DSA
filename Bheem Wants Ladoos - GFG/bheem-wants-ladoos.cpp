//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};

Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    
    return temp;
}

Node* buildTree(string str)
{   
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;
    
    // Creating vector of strings from input 
    // string after spliting by space
    vector<string> ip;
    
    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);
        
    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));
        
    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);
        
    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {
            
        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();
            
        // Get the current node's value from the string
        string currVal = ip[i];
            
        // If the left child is not null
        if(currVal != "N") {
                
            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->left);
        }
            
        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];
            
        // If the right child is not null
        if(currVal != "N") {
                
            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }
    
    return root;
}


// } Driver Code Ends
/*
// node structure:

struct Node
{
    int data;
    Node* left;
    Node* right;
};

*/


class Solution{

    public:
    Node* home_add;
    void store(Node* root,unordered_map<Node*,Node*> &parent_track, int home){
        if(!root) return ;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            Node* cur=q.front();
            q.pop();
            
            if(cur->data==home) home_add = cur;
                    
            if(cur->left){
                parent_track[cur->left]=cur;
                q.push(cur->left);
            }
            if(cur->right){
                parent_track[cur->right]=cur; 
                 q.push(cur->right);
            }
        }
    }
    
    int ladoos(Node* root, int home, int k)
    {
        int sum = home;
        unordered_map<Node*,Node*> parent_track;
        store(root, parent_track, home);
        
         unordered_map<Node*,bool> vis;
      
        queue<Node*> q;
        q.push(home_add);
        vis[home_add]=1;
        int cur_level=0;
        
        while(!q.empty()){
            
            int size=q.size();
            if(cur_level++==k)break;
            for(int i=0;i<size;i++){
                Node* cur=q.front();
                q.pop();
                
            if(cur->left && !vis[cur->left]){
                sum+=cur->left->data;
                q.push(cur->left);
                vis[cur->left]=1;
            }
             
             if(cur->right && !vis[cur->right]){
                 sum+=cur->right->data;
                  q.push(cur->right);
                 vis[cur->right]=1;
             }
             
             if(!vis[parent_track[cur]] && parent_track[cur]){
                 sum+=parent_track[cur]->data;
                 vis[parent_track[cur]]=1;
                 q.push(parent_track[cur]);
             }
                 
             }
        }
        
        return sum;
        
        
    }


};


//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    getchar();
    
    while(t--)
    {
        string s;
        getline(cin,s);
        Node* root = buildTree(s);
        
        int home,k;
        cin>> home >> k;
        getchar();
        Solution obj;
        cout<< obj.ladoos(root,home,k) << endl;
    }
	return 0;
}


// } Driver Code Ends