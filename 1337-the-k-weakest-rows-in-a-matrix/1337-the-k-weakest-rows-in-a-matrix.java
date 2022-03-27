class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiersInRows = new int[mat.length];
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1) count++;
                else break;
            }
            soldiersInRows[i] = count;
        }
        int[] ans = new int[k];
        for(int i = 0; i< k; i++){
            ans[i] = nthWeakestRow(soldiersInRows, i);
        }
        return ans;
    }
    
    static int nthWeakestRow(int[] arr, int n){
        int[] arr_copy = arr.clone();
        Arrays.sort(arr_copy);
        int num = arr_copy[n];
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==num){
                arr[i] = -1;
                return i;
            }
        }
        return -1;
    }
}