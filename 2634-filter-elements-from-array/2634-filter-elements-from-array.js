/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let ans = [];
    
    for(const i in arr){
        if(fn(arr[i], Number(i))){
            ans.push(arr[i]);
        }
    }
    
    return ans;
};