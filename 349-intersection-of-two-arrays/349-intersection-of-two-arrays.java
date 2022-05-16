class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map1 = new HashMap<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        mapping(nums1, map1);
        mapping(nums2, map2);
        for (Map.Entry<Integer, Boolean> e: map1.entrySet()){
            if (map2.containsKey(e.getKey())){
                ans.add(e.getKey());
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    static void mapping(int[] nums, HashMap<Integer, Boolean> map){
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], true);
            }
        }
    }
}