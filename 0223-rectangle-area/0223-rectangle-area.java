class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1 = ax2 - ax1;
        int b1 = ay2 - ay1;        
        int area1 = l1*b1;
        
        int l2 = bx2 - bx1;
        int b2 = by2 - by1;
        int area2 = l2*b2;
        
        // completely overlapping area
        if((ax1 <= bx1 && ax2 >= bx2 && ay2 >= by2 && ay1 <= by1) || (bx1 <= ax1 && bx2 >= ax2 && by2 >= ay2 && by1 <= ay1)){
            return Math.max(area1, area2);
        }
        
        // no overlapping area
        if(bx1 >= ax2 || bx2 <= ax1 || by2 <= ay1 || ay2 <= by1){
            return area1 + area2;
        }
        
        // some part overlapping area
        int hidLen = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int hidWid = Math.min(ay2, by2) - Math.max(ay1, by1);
               
        return area1 + area2 - hidLen*hidWid;
    }
}