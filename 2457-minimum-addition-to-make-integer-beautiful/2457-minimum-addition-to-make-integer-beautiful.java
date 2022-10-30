class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0){
            int rem = (int)(n%10);
            list.add(rem);
            n /= 10;
        }
        int sum = getSumOfDigits(list);
        ArrayList<Integer> result = new ArrayList<>();

        while(sum > target){
            int lastDigit = list.get(0);
            if(lastDigit == 0){
                list.remove(0);
                result.add(0);
                continue;
            }

            int addedNum = 10 - lastDigit;
            list.remove(0);
            result.add(addedNum);
            int zeros = addOneToNum(list);
            while(zeros-- > 0){
                result.add(0);
            }
            sum = getSumOfDigits(list);
        }

        long ans = 0;
        for(int i = result.size() - 1; i >= 0; i--){
            ans += Math.pow(10, i)*result.get(i);
        }

        return ans;
    }

    private int addOneToNum(ArrayList<Integer> list){
        if(list.size() == 0){
            list.add(1);
            return 0;
        }
        int zeros = 0;
        int lastDigit = list.get(0);
        list.remove(0);
        if(lastDigit < 9){
            list.add(0,lastDigit + 1);
        }else{
            zeros = 1 + addOneToNum(list);
        }

        return zeros;
    }
    
    private int getSumOfDigits(ArrayList<Integer> list){
        int sum = 0;
        
        for(int num: list){
            sum += num;
        }
        
        return sum;
    }
}