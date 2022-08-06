class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i] , i);
        }
        
        int[] ans = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++){
            int nextGreater = -1;
            for(int j = map.get(nums1[i]) + 1; j < nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    nextGreater = nums2[j];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        
        return ans;
    }
}