class Solution {
    public List<String> buildArray(int[] target, int n) {
        // List<Integer> memo = new ArrayList<>();
        // for(int nums : target){
        //     memo.add(nums);
        // }
        List<String> ans = new ArrayList<>();
        int i = 0;
        int num = 1;
        while( num <= target[target.length-1]){
            ans.add("Push");
            if(!(num==target[i])){
                ans.add("Pop");
                i--;
            }
            num++;
            i++;
        }
        return ans;
    }
}