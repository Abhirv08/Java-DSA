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

        int l = 0, r = n - 1;  
        int smallest = num;

        while(l <= r){
            int m = l + (r-l)/2;
            
            int diff = num - primes.get(m);
            if(diff <= target){
                r = m - 1;
            }else{
                smallest = Math.min(smallest, diff);
                l = m + 1;
            }
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