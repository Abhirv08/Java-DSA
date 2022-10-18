class Pair{
    char ch;
    int freq;
    
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq  = freq;
    }
}
class Solution {    
    public String countAndSay(int n) {
        String s = "1";
        
        while(n > 1){
            ArrayList<Pair> list = countFreq(s);
            s = stringify(list);
            n--;
        }       
        
        return s;
    }
    
    private ArrayList<Pair> countFreq(String s){
        ArrayList<Pair> list = new ArrayList<>();
        
        char curr = s.charAt(0);
        int count = 0;
        for(char letter: s.toCharArray()){
            if(letter == curr){
                count++;
            }else{
                list.add(new Pair(curr, count));
                curr = letter;
                count = 1;
            }
        }
        list.add(new Pair(curr, count));
        
        return list;
    }
    
    private String stringify(ArrayList<Pair> list){
        StringBuilder ans = new StringBuilder();
        
        for(Pair p: list){
            ans.append(p.freq);
            ans.append(p.ch);
        }
        
        return ans.toString();
    }
}