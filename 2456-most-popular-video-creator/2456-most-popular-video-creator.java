class Pair implements Comparable<Pair>{
    String name;
    int popularity;
    int lexiSmallIdx;
    public Pair(String name, int popularity, int lexiSmallIdx){
        this.name = name;
        this.popularity = popularity;
        this.lexiSmallIdx = lexiSmallIdx;
    }
    public int compareTo(Pair p){
        return p.popularity - this.popularity;
    }
}


class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < views.length; i++){
            if(!map.containsKey(creators[i])){
                map.put(creators[i], new ArrayList<>());
            }
            map.get(creators[i]).add(i);
        }
        
        Pair[] p = new Pair[map.size()];
        
        int i = 0;
        for(String name: map.keySet()){
            int popularity = 0;
            int lexiSmallIdx = -1;
            for(int idx: map.get(name)){
                popularity += views[idx];
                if(lexiSmallIdx == -1){
                    lexiSmallIdx = idx;
                }else if(views[idx] == views[lexiSmallIdx]){
                    if(ids[idx].compareTo(ids[lexiSmallIdx]) < 0){
                        lexiSmallIdx = idx;
                    }
                }else if(views[idx] > views[lexiSmallIdx]){
                    lexiSmallIdx = idx;
                }
            }
            p[i] = new Pair(name, popularity, lexiSmallIdx);
            i++;
        }
        
        Arrays.sort(p);
        List<List<String>> ans = new ArrayList<>();
        
        int maxPopularity = p[0].popularity;
        i = 0;
        while(i < p.length && p[i].popularity == maxPopularity){
            List<String> temp = new ArrayList<>();
            temp.add(p[i].name);
            temp.add(ids[p[i].lexiSmallIdx]);
            ans.add(temp);
            i++;
        }
        
        return ans;
    }
}