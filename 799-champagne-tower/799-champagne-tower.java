class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0){
            return 0;
        }
        ArrayList<Double> l = new ArrayList<>();
        l.add((double)(poured)); 
        while(query_row-- > 0){
            ArrayList<Double> temp = new ArrayList<>();
            temp.add(Math.max( (l.get(0)-1)/2 , 0));
            for(int c = 1; c < l.size(); c++){
                temp.add(Math.max(0, (l.get(c-1)-1)/2 ) + Math.max(0, (l.get(c)-1)/2 )  );
            }            
            temp.add(temp.get(0));
            l = new ArrayList<>(temp);   
        }
        
        return Math.min(1, l.get(query_glass));
    }
}