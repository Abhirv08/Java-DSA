class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> list = new ArrayList<>();
        
        while(k > 0){
            list.add(k%10);
            k /= 10;
        }
        
        //System.out.println(list);
        int i = n - 1, j = 0;
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        while(i >= 0 && j < list.size()){
            int num1 = num[i];
            int num2 = list.get(j);
            int sum = num1+num2+carry;
            if(sum <= 9){
                ans.add(sum);
                carry = 0;
            }else{
                ans.add(sum%10);
                carry = sum/10;
            }
            i--;
            j++;
        }
        
        while(i >= 0){
            int sum = num[i] + carry;
            if(sum <= 9){
                ans.add(sum);
                carry = 0;
            }else{
                ans.add(sum%10);
                carry = sum/10;
            }
            i--;
        }
        
        while(j < list.size()){
            int sum = list.get(j) + carry;
            if(sum <= 9){
                ans.add(sum);
                carry = 0;
            }else{
                ans.add(sum%10);
                carry = sum/10;
            }
            j++;
        }        
        
        if(carry == 1) ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}