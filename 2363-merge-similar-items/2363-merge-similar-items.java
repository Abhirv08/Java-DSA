class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int[] item : items2){
            memo.put(item[0], item[1]);
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int[] item : items1){
            int val = item[0];
            int wt = item[1];
            if(memo.containsKey(val)){
                wt += memo.get(val);
                memo.remove(val);
            }
            
            List<Integer> temp = new ArrayList<>();
            temp.add(val);
            temp.add(wt);
            list.add(temp);
        }
        
        for(Map.Entry<Integer, Integer> e : memo.entrySet()){
            int val = e.getKey();
            int wt = e.getValue();
            
            List<Integer> temp = new ArrayList<>();
            temp.add(val);
            temp.add(wt);
            list.add(temp);
        }
        
        Collections.sort(list, new Comparator<List<Integer>>() {            
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        
        return list;
    }
}