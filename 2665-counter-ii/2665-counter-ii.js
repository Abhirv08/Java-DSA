/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let num = init;
    
    function increment(){
        num += 1
        return num;
    }
    
    function reset(){
        num = init
        return num
    }
    
    function decrement(){
        num -= 1
        return num
    }
    
    return { increment, decrement, reset };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */