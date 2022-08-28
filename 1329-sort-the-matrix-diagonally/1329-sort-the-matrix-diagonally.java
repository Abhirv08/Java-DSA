class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        HashMap<Integer, PriorityQueue<Integer>> memo = new HashMap<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                memo.put((j - i), new PriorityQueue<>() );
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                memo.get( j - i).add(mat[i][j]);
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int key = j- i;
                mat[i][j] = memo.get(key).remove();

                if(memo.get(key).size() == 0){
                    memo.remove(key);
                }
            }
        }

        return mat;     
    }
}