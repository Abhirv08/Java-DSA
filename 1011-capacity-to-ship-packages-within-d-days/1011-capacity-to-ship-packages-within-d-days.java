class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int r = 500*50000;
        while(l < r){
            int mid = (l+r)/2;
            if(isOk(mid, weights, days)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    
    static boolean isOk(int mid, int[] weight, int days){
        int noOfDays = 1;
        int totalWeight = 0;
        for(int i = 0; i < weight.length; i++){
            if(weight[i] > mid){
                return false;
            }
            if(weight[i]+totalWeight <= mid){
                totalWeight += weight[i];
            }else{
                noOfDays++;
                totalWeight = weight[i];
            }
        }
        
        return noOfDays <= days;
    }
}