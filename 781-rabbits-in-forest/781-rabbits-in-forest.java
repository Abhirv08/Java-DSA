class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int currval : answers){
           if(!memo.containsKey(currval)){
               memo.put(currval, 1);
           }else{
               memo.put(currval, memo.get(currval)+1);
           }
        }
        
        int answer = 0;
        for(Map.Entry<Integer, Integer> e : memo.entrySet()){
            int gsize = e.getKey()+1;
            int rep = e.getValue();
            
            if(rep % gsize == 0){
                answer += (rep/gsize)*gsize;
            }else{
                answer += (rep/gsize + 1)*gsize;
            }
            
        }
        
        return answer;
    }
}