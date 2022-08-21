class Solution {
    public static int[] movesToStamp(String stamp, String target) {
        int n = target.length();
        ArrayList<Integer> list = new ArrayList<>();

        StringBuilder tgt = new StringBuilder(target);
        String actTgt = new String();

        for(int i = 0; i < n; i++){
            actTgt += "?";
        }

        while(!target.equals(actTgt)){
            int index = updateTarget(stamp, tgt);
            target = tgt.toString();
            if(index == n){
                return new int[0];
            }

            list.add(index);
        }

        int[] ans = new int[list.size()];

        for(int i = list.size() - 1; i >= 0; i--){
            ans[list.size() - 1 - i] = list.get(i);
        }

        return ans;
    }

    private static int updateTarget(String stamp, StringBuilder target){
        int n = target.length();

        for(int i = 0; i < n; i++){

            int j = 0, temp = i;
            boolean canBeStamped = false;

            while(j < stamp.length() && temp < n && (stamp.charAt(j) == target.charAt(temp) || target.charAt(temp) == '?')){

                if(target.charAt(temp) != '?'){
                    canBeStamped = true;
                }

                temp++;
                j++;
            }

            if(j == stamp.length() && canBeStamped){
                for(int k = 0; k < stamp.length(); k++){
                    target.replace(i + k, i + k + 1, "?");
                }

                return i;
            }

        }

        return n;
    }
}