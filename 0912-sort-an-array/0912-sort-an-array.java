class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        return mergeSort(nums, 0, n-1);
    }
    
    private int[] mergeSort(int[] nums, int l, int r){
        if(l == r) return new int[]{nums[l]};
        int m = l + (r - l)/2;
        
        int[] left = mergeSort(nums, l, m);
        int[] right = mergeSort(nums, m+1, r);
        
        return merge(left, right);
    }
    
    int[] merge(int[] l, int[] r){
        int[] ans = new int[l.length + r.length];
        
        int i = 0, j = 0, k = 0;
        while(i < l.length && j < r.length){
            if(l[i] <= r[j]){
                ans[k] = l[i];
                i++;
                k++;
            }else{
                ans[k] = r[j];
                j++;
                k++;
            }
        }
        
        while(i < l.length){
            ans[k] = l[i];
            i++;
            k++;
        }
        
        while(j < r.length){
            ans[k] = r[j];
            j++;
            k++;
        }
        
        return ans;
    }
}