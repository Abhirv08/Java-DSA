class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] vertices = new int[4][2];
        vertices[0][0] = p1[0];
        vertices[0][1] = p1[1];
        vertices[1][0] = p2[0];
        vertices[1][1] = p2[1];
        vertices[2][0] = p3[0];
        vertices[2][1] = p3[1];
        vertices[3][0] = p4[0];
        vertices[3][1] = p4[1];
        
        Arrays.sort(vertices, (a,b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        double l1 = findSize(vertices[0], vertices[1]);
        double l2 = findSize(vertices[0], vertices[2]);
        double l3 = findSize(vertices[1], vertices[3]);
        double l4 = findSize(vertices[2], vertices[3]);        
        
        //System.out.println(l1 + ":" + l2 +":" + l3 +":" + l4);
        
        if(l1 == 0 || l2 == 0 || l3 == 0 || l4 == 0) return false; 
        
        if(l1 == l2 && l2 == l3 && l3 == l4){
            //System.out.println("hello");
            boolean a1 = findAngle(vertices[1], vertices[0], vertices[2]);
            boolean a2 = findAngle(vertices[0], vertices[1], vertices[3]);
            boolean a3 = findAngle(vertices[1], vertices[3], vertices[2]);
            boolean a4 = findAngle(vertices[0], vertices[2], vertices[3]);
            
            //System.out.println(a1 + ":" + a2 +":" + a3 +":" + a4);
            
            if(a1 && a2 && a3 && a4) return true;
        }
        
        return false;
    }
    
    private boolean findAngle(int[] left, int[] mid, int[] right){
        int x1 = left[0] - mid[0];
        int y1 = left[1] - mid[1];
        
        int x2 = right[0] - mid[0];
        int y2 = right[1] - mid[1];
        
        return x1*x2 + y1*y2 == 0;
    }
    
    private double findSize(int[] p1, int[] p2){
        int y = p1[1] - p2[1];
        int x = p1[0] - p2[0];
        
        return Math.sqrt(x*x + y*y);
    }
}