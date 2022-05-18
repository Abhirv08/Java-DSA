class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> memo1 = new HashMap<>();        
        HashMap<Integer, Integer> memo2 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(memo1.containsKey(nums1[i])){
                memo1.put(nums1[i], memo1.get(nums1[i])+1);
            }else{
                memo1.put(nums1[i], 1);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            if(memo2.containsKey(nums2[i])){
                memo2.put(nums2[i], memo2.get(nums2[i])+1);
            }else{
                memo2.put(nums2[i], 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : memo1.entrySet() ){
            if(memo2.containsKey(e.getKey())){
                for(int i = 1; i <= Math.min(e.getValue(), memo2.get(e.getKey())); i++){
                    ans.add(e.getKey());
                }
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