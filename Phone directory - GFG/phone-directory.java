//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Trie{
    Trie[] children;
    HashMap<String, TreeSet<String>> map;
    
    public Trie(){
        children = new Trie[26];
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        this.map = new HashMap<>();
    }
}
class Solution{
    
    static Trie root;
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        root = new Trie();
        
        for(String con: contact){
            insert(con);
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            String prefix = s.substring(0, i+1);
            TreeSet<String> set = getWords(prefix);
            ArrayList<String> temp = new ArrayList<>();
            for(String val: set){
                temp.add(val);
            }
            if(temp.size() == 0) temp.add("0");
            ans.add(temp);
        }
        
        return ans;
    }
    
    static void insert(String s){
        Trie temp = root;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new Trie();
            }
            
            String key = s.substring(0, i + 1);
            if(!temp.map.containsKey(key)){
                temp.map.put(key, new TreeSet<>());
            }
            temp.map.get(key).add(s);
            temp = temp.children[ch - 'a'];
        }
    }
    
    static TreeSet<String> getWords(String s){
        TreeSet<String> set = new TreeSet<>();
        
        Trie temp = root;
        for(int i = 0; i < s.length() - 1; i++){
            char ch = s.charAt(i);
            if(temp.children[ch - 'a'] == null){
                return set;
            }
            
            temp = temp.children[ch - 'a'];
        }
        
        set = temp.map.getOrDefault(s, new TreeSet<>());
        
        return set;
    }
}