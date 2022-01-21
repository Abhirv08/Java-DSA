// ASKED IN GOOGLE CODING INTERVIEW

// Q. Find maximum distinct elements after removing k elements from given array of length 'n'.

// // NOTE: 1 <= k <= n

// Example: arr[] = {5,7,5,5,1,2,3}, k=3
// Output: 4

// CODE:

// TIME COMPLEXITY: O(n)
// SPACE COMPLEXITY: O(n)

static int maxDisticnt(int[] nums, int k) {
       Arrays.sort(nums);
       int n = nums.length;
       int count = 1;
       List<Integer> helper = new ArrayList<>();
       int temp = nums[0];
       for(int i = 1; i< n; i++){
           if (nums[i] == temp){
               count++;
           }else{
               helper.add(count);
               count = 1;
               temp = nums[i];
           }
           if (i==n-1){
               helper.add(count);
           }
       }
        for (int i = 0; i < helper.size(); i++) {
            if (helper.get(i)!=1){
                k -= (helper.get(i)-1);
            }
            if (i==n-1){
                if (k > 0){
                    return helper.size()-k;
                }
            }
        }
        return helper.size();
    }
