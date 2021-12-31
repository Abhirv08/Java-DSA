class Solution {
    public boolean hasAlternatingBits(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(num> 0){
            arr.add( num&1 );
            num = num >> 1;
        }
        for(int i = 0; i< arr.size()-1; i++){
            if(arr.get(i)==arr.get(i+1)){
                return false;
            }
        }
        return true;
    }
}