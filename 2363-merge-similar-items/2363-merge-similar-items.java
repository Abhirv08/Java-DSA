class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> memo1 = new HashMap<>();
        
        for(int[] item : items1){
            memo1.put(item[0], item[1]);
        }
        
        HashMap<Integer, Integer> memo2 = new HashMap<>();
        
        for(int[] item : items2){
            memo2.put(item[0], item[1]);
        }
        List<List<Integer>> list = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> e : memo1.entrySet()){
            int val = e.getKey();
            int wt = e.getValue();
            if(memo2.containsKey(val)){
                wt += memo2.get(val);
                memo2.remove(val);
            }
            
            List<Integer> temp = new ArrayList<>();
            temp.add(val);
            temp.add(wt);
            list.add(temp);
        }
        
        for(Map.Entry<Integer, Integer> e : memo2.entrySet()){
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