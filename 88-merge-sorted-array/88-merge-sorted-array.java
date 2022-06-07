class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            
        // for(int i = 0; i < n; i++){
        //     nums1[m+i] = nums2[i];
        // } 
        // Arrays.sort(nums1);
        
        int[] temp = new int[m+n];
        int i = 0;int j = 0;int k = 0;
        while( i < m && j < n){
            if(nums1[i] < nums2[j]){
                temp[k] = nums1[i];
                i++;
            }else{
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while( i < m){
            temp[k] = nums1[i];
            i++; k++;
        }
        while( j < n){
            temp[k] = nums2[j];
            j++;k++;
        }
        
        for(i = 0; i < m+n; i++){
            nums1[i] = temp[i];
        }
    }
}