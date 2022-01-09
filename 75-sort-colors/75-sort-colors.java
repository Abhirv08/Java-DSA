class Solution {
    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }
    
    static void  mergeSort(int[] arr, int lb, int ub){
        if (lb<ub){
            int mid = (ub+lb)/2;
            mergeSort(arr,lb,mid);
            mergeSort(arr,mid+1,ub);
            merge(arr, lb, mid, ub);
        }
    }

    private static void merge(int[] arr, int lb, int mid, int ub) {
        int n1 = mid-lb+1;
        int n2 = ub-mid;
        int[] left_arr = new int[n1];
        int[] right_arr = new int[n2];
        for (int i = 0; i < n1; i++)
            left_arr[i] = arr[lb + i];
        for (int j = 0; j < n2; j++)
            right_arr[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = lb;
        while (i<n1 && j<n2){
            if (left_arr[i] <= right_arr[j]){
                arr[k] = left_arr[i];
                i++;
            }else {
                arr[k] = right_arr[j];
                j++;
            }
            k++;
        }
        while(j < n2){
            arr[k] = right_arr[j];
            j++;
            k++;
        }
        while(i < n1){
            arr[k] = left_arr[i];
            i++;
            k++;
        }
    }
}