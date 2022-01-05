class Solution {
    public boolean isHappy(int n) {
      List<Integer> occuredNum = new ArrayList<>();
        while ( n!= 1 && !occuredNum.contains(nextNum(n)) ){
            occuredNum.add(n);
            n = nextNum(n);
        }
        return n==1;
    }
    static int nextNum(int n){
        int num = 0;
        while(n > 0){
            int remndr = n%10;
            num += (remndr*remndr);
            n /= 10;
        }
        return num;
    }
}