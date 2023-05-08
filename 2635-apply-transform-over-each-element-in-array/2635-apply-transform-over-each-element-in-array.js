/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let ans = [];
    for(const i in arr){
        ans[i] = fn(arr[i], Number(i));
    }
    return ans;
};