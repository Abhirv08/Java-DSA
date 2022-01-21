class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] fact = new int[n+1];
        fact[0] = 1;
        for(int i = 0; i < n; i++){
            list.add(i+1);
            fact[i+1] = (i+1)*fact[i];
        }
        String ans = "";
        return kthNum(ans, list, k, fact);
    }

    static String kthNum(String ans, ArrayList<Integer> list, int k, int[] fact){
        while(list.size()>1){
            int index = k/fact[list.size()-1];
            if(k%fact[list.size()-1]==0){
                index--;
            }
            ans += list.get(index);
            k -= (fact[list.size()-1]*index);
            list.remove(index);
        }
        ans += list.get(0);
        return ans;
    }
}