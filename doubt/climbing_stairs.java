//70. Climbing Stairs

//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Example 1:
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps

//Example 2:
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step

Code:
class Solution {
    public int climbStairs(int n) {                
       int y = 0;        //2's step
        int ways = 0;
        while(2*y <= n){
            int x = n-2*y;
            if((int)x == x && (x!=0 && y!=0)){
                ways+= ( factorial(x+y)/(factorial(y)*factorial(x)) );
            }else if((int)x == x &&(x==0 || y==0)){
                ways++;
            }
            y++;
        }
        return ways;
    }
    static long factorial(int num){
        if(num==0 || num==1){
            return 1;
        }
        return num*factorial(num-1);
    }
}
