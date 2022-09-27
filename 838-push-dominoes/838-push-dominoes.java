class Solution {
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();

        if(n == 0){
            return "";
        }

        char[] chars = dominoes.toCharArray();

        // for right falling dominoes
        char[] rightFalling = new char[n];
        for(int i = 0; i < n; i++){
            if(chars[i] == 'R'){
                while(i < n && chars[i] != 'L'){
                    rightFalling[i] = 'R';
                    i++;
                }
            }
            if(i < n)
                rightFalling[i] = chars[i];
        }

        char[] leftFalling = new char[n];
        for(int i = n-1; i >= 0; i--){
            if(chars[i] == 'L'){
                while(i >= 0 && chars[i] != 'R'){
                    leftFalling[i] = 'L';
                    i--;
                }
            }
            if(i >= 0){
                leftFalling[i] = chars[i];
            }
        }


        for(int i = 0; i < n; i++){
            if(leftFalling[i] == '.'){
                if(rightFalling[i] != '.') {
                    chars[i] = rightFalling[i];
                }
            }else if(rightFalling[i] == '.'){
                if(leftFalling[i] != '.'){
                    chars[i] = leftFalling[i];
                }
            }else{
                if(leftFalling[i] != rightFalling[i]){
                    int start = i;
                    int end = 0;
                    while(leftFalling[i] != rightFalling[i]){
                        i++;
                    }
                    end = i - 1;

                    makeProper(chars, start, end);
                }
            }
        }
        StringBuilder ans = new StringBuilder();

        for(char c : chars){
            ans.append(c);
        }

        return ans.toString();
    }

    private static void makeProper(char[] chars, int start, int end) {
        while(start < end){
            chars[start] = chars[start-1];
            chars[end] = chars[end+1];
            start++;
            end--;
        }

        if(start == end){
            chars[start] = '.';
        }

    }
}