class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        
        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        HashSet<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }
        
        for(int num: nums2){
            set2.add(num);
        }
        
        for(int num: nums1){
            if(!set2.contains(num)){
                p1.add(num);
            }
        }
        
        for(int num: nums2){
            if(!set1.contains(num)){
                p2.add(num);
            }
        }
        
        ans.add(new ArrayList<>(p1));
        ans.add(new ArrayList<>(p2));
        
        return ans;
    }
}