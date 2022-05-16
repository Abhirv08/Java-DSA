class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map1 = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        mapping(nums1, map1);
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i]) && map1.get(nums2[i])){
                ans.add(nums2[i]);
                map1.replace(nums2[i],true, false);
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