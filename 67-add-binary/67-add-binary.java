class Solution {
    static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int rem = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                rem += (a.charAt(i) - '0');
            }
            if (j >= 0) {
                rem += (b.charAt(j) - '0');
            }
            result.append((rem % 2));
            rem /= 2;
            i--;
            j--;
        }
        if (rem > 0) {
            result.append(rem);
        }
        return result.reverse().toString();
    }

    
}