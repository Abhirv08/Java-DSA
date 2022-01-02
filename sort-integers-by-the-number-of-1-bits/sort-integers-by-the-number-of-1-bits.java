class Solution {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> ans_helper = new ArrayList<>();
        ans_helper.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            ans_helper.add(arr[i]);
            for ( int j =0; j < ans_helper.size()-1; j++) {
                if (Integer.bitCount(ans_helper.get(ans_helper.size()-j-1)) < Integer.bitCount(ans_helper.get(ans_helper.size()-j-2))){
                    int temp = ans_helper.get(ans_helper.size()-j-2);
                    ans_helper.set(ans_helper.size()-j-2, ans_helper.get(ans_helper.size()-j-1)) ;
                    ans_helper.set(ans_helper.size()-j-1, temp);
                }else if ( Integer.bitCount(ans_helper.get(ans_helper.size()-j-1)) == Integer.bitCount(ans_helper.get(ans_helper.size()-j-2)) && ans_helper.get(ans_helper.size()-j-1)<ans_helper.get(ans_helper.size()-j-2) ){
                    int temp = ans_helper.get(ans_helper.size()-j-2);
                    ans_helper.set(ans_helper.size()-j-2, ans_helper.get(ans_helper.size()-j-1)) ;
                    ans_helper.set(ans_helper.size()-j-1, temp);
                }else{
                    break;
                }
            }

        }
        for (int i = 0; i < ans_helper.size(); i++) {
            arr[i] = ans_helper.get(i);
        }
        return arr;
    }
}