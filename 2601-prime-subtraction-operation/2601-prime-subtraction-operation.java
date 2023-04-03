class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = -1;
        for(int n: nums) max = Math.max(max, n);
        
        List<Integer> primes = getPrimes(max+1);
        
        int num = getLeastPrime(primes, nums[0], 0);
        nums[0] = num;
        for(int i = 1; i < nums.length; i++){
            num = getLeastPrime(primes, nums[i], nums[i-1]);
            nums[i] = num;
        }
        
        System.out.println(Arrays.toString(nums));
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]) return false;
        }
        
        return true;
    }
    
    private int getLeastPrime(List<Integer> primes, int num, int target){
        int n = primes.size();

        int r = n - 1;

        while(r >= 0 && num - primes.get(r) <= target) r--;

        int smallest = num;

        while(r >= 0 && num - primes.get(r) > target){
            smallest = Math.min(smallest, num - primes.get(r));
            r--;
        }

        return smallest;
    }
    
    private List<Integer> getPrimes(int max){
        int[] nums = new int[max];
        
        for(int i = 1; i < max; i++){
            nums[i] = i;
        }
        nums[0] = nums[1] = -1;
        for(int i = 2; i < max; ){
            for(int j = 2*i; j < max; j += i){
                nums[j] = -1;
            }
            
            i++;
            while(i < max && nums[i] == -1){
                i++;
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        
        for(int i = 0; i < max; i++){
            if(nums[i] > 0){
                primes.add(nums[i]);
            }
        }
        
        return primes;
    }
}