class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n==0) return;
        int i = 0, j = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                i++;
            }else{
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;    
                Arrays.sort(nums2);
            }
        }
        while(i < m+n){
            nums1[i] = nums2[j];
            j++;
            i++;
        }
            
    }
}