class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        
        int min = Integer.MAX_VALUE, max = 0;
        int sum = 0;
        for(int s: salary){
            if(min > s){
                min = s;
            }
            if(max < s){
                max = s;
            }
            sum += s;
        }
        
        sum = sum - max - min;
        
        return (double) sum/(n - 2);
    }
}