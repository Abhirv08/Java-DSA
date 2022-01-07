class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zeros = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0){
                    zeros.add(Arrays.asList(row, col));
                }
            }
        }
        for (int i = 0; i < zeros.size(); i++) {
            int row = (zeros.get(i)).get(0);
            int col = (zeros.get(i)).get(1);
            for (int j = 0; j < matrix.length; j++) {            // traversing through rows
                for (int k = 0; k < matrix[0].length; k++) {    //traversing through columns
                    if ( j==row || k==col ){
                        matrix[j][k] = 0;
                    }
                }
            }
        }
 
    }
}