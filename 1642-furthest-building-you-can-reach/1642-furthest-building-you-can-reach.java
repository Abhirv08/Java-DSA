class Solution {
    public int furthestBuilding(int[] h, int b, int l){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < h.length - 1; i++){
            int diff = h[i+1] - h[i];
            if(diff > 0){
                pq.add(diff);
            }
            if(pq.size() > l){
                b -= pq.poll();
            }
            
            if(b < 0){
                return i;
            }
        }
        
        return h.length - 1;
    } 


//     TLE Approach
//     public int furthestBuilding(int[] heights, int bricks, int ladders) {
//         int[] ans = {0};
//         int index = furthest(heights, bricks, ladders, 0, ans);
//         return ans[0];
//     }
    
//     private int furthest(int[] heights, int bricks, int ladders, int index, int[] ans){
//         if(bricks < 0 || ladders < 0 || index == heights.length){
//             ans[0] = Math.max(ans[0], index - 1);
//             return 0;
//         }
        
//         int bricksPath = 0;
//         int laddersPath = 0;
//         if(index < heights.length - 1 && heights[index+1] - heights[index] <= 0){
//             furthest(heights, bricks, ladders, index+1, ans);
//         }else{
//             if(index < heights.length - 1){
//                 bricksPath = furthest(heights, bricks - (heights[index+1] - heights[index]), ladders, index + 1, ans);
//             }
//             laddersPath = furthest(heights, bricks , ladders - 1, index + 1, ans);
//         }
        
//         return Math.max(bricksPath, laddersPath);
//     }
}