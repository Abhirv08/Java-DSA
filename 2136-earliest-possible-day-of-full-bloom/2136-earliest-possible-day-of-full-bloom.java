class Pair implements Comparable<Pair>{
    int plantTime, growTime;
    
    public Pair(int plantTime, int growTime){
        this.plantTime = plantTime;
        this.growTime = growTime;
    }
    
    public int compareTo(Pair p){
        if(p.growTime == this.growTime){
            return this.plantTime - p.plantTime;
        }
        
        return p.growTime - this.growTime;
    }
}
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            list.add(new Pair(plantTime[i], growTime[i]));
        }
        
        Collections.sort(list);
        // for(Pair x: p){
        //     System.out.println(x.plantTime + ":" + x.growTime);
        // }
        
        int daysRequired = 0, currPlantTime = 0;
        
        
        for(int i = 0; i < list.size(); i++){
            int timeToBlossom = list.get(i).plantTime + list.get(i).growTime + currPlantTime; 
            daysRequired = Math.max(daysRequired, timeToBlossom);
            currPlantTime += list.get(i).plantTime;
        }
        
        return daysRequired;
    }
}