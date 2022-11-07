class Solution {
    public int maximum69Number (int num) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(num > 0){
            int rem = num%10;
            list.add(0, rem);
            num /= 10;
        }
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 6){
                list.remove(i);
                list.add(i, 9);
                break;
            }
        }

        int ans = 0;
        for(int i = 0; i < list.size(); i++){
            ans += Math.pow(10, list.size() - 1 - i)*list.get(i);
        }
        
        return ans;
    }
}