class NumArray {
    private int[] nums;
    private int segLength;
    private int[] partsSum;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        segLength = (int) Math.ceil(nums.length / l);
        partsSum = new int[segLength];
        for(int i = 0; i < nums.length; i++){
            partsSum[i/segLength] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int idx = index/segLength;
        partsSum[idx] = partsSum[idx] - nums[index] + val;
        nums[index] = val;        
        return ;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        int s = left/segLength;
        int e = right/segLength;
        
        if(s == e){
            for(int i = left; i <= right; i++){
                sum += nums[i];
            }
        }else{
            for(int i = left; i <= (s + 1)*segLength-1; i++){
                sum += nums[i];
            }
            
            for(int i = s + 1; i <= e-1; i++){
                sum += partsSum[i];
            }
            for(int i = e*segLength; i <= right; i++){
                sum += nums[i];
            }
        }
        
        return sum;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */