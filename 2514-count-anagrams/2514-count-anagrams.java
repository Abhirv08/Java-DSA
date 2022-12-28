import java.math.BigInteger;
class Solution {
    long mod = (long) (1e9 + 7);
    long[] fac;
    public int countAnagrams(String s) {

        fac = new long[s.length() + 1];
        fac[1] = 1;
      for (int i = 2; i <= s.length(); i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }
        String[] ws = s.split(" ");
        long ans = 1;
        for (String w : ws) {
            ans = (ans * calc(w)) % mod;
        }
        return (int)ans;
    }
    private long calc(String w) {
        Map<Character, Integer> m = new HashMap<>();
        for (char ch : w.toCharArray()) {
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }
        long all = fac[w.length()];
        for (int v : m.values()) {
            long inv = BigInteger.valueOf(fac[v]).modInverse(BigInteger.valueOf(mod)).longValue();
            all = all * inv % mod;
        }
        return all;
    }
}