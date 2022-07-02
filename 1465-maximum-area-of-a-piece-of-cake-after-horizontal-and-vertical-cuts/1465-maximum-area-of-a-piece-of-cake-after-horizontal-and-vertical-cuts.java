class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        long mod = (long) (1e9+7);
        Arrays.sort(hc);
        Arrays.sort(vc);
        int hcuts = 0;
        int vcuts = 0;

        long height = hc[hcuts];
        long width = vc[vcuts];


        while (hcuts < hc.length - 1){
            height = Math.max(height, hc[hcuts + 1] - hc[hcuts]);
            hcuts++;
        }
        height = Math.max(height, h - hc[hcuts]);

        while (vcuts < vc.length - 1){
            width = Math.max(width, vc[vcuts + 1] -vc[vcuts]);
            vcuts++;
        }
        width = Math.max(width, w - vc[vcuts]);

        width = width%mod;
        height = height%mod;
        long ans = (width*height)%mod;

        return (int)ans;
    }
}