class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> memo = new HashMap<>();   
        for(int i = 0; i < nums1.length; i++){
            if(memo.containsKey(nums1[i])){
                memo.put(nums1[i], memo.get(nums1[i])+1);
            }else{
                memo.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            if(memo.containsKey(nums2[i]) && memo.get(nums2[i]) > 0){
                ans.add(nums2[i]);
                memo.put(nums2[i], memo.get(nums2[i])-1);
            }
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }   
        return result;
    }
//     public int[] intersect(int[] nums1, int[] nums2) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int i = 0, j = 0;
//         ArrayList<Integer> ans = new ArrayList<>();
//         while( i < nums1.length && j < nums2.length){
//             if(nums1[i] == nums2[j]){
//                 ans.add(nums1[i]);
//                 i++;
//                 j++;
//             }else if(nums1[i] > nums2[j]){
//                 j++;
//             }else{
//                 i++;
//             }
                            
//         }
//         int[] result = new int[ans.size()];
//         for(int k = 0; k < ans.size(); k++){
//             result[k] = ans.get(k);
//         }
//         return result;
//     }
}