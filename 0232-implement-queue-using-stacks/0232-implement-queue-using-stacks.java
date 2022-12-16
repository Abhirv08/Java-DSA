class MyQueue {
    Stack<Integer> pri;
    Stack<Integer> temp;
    int top;
    public MyQueue() {
        pri = new Stack<>();
        temp = new Stack<>();
        top = -1;
    }
    
    public void push(int x) {
        if(pri.isEmpty()){
            top = x;
        }
        pri.push(x);
    }
    
    public int pop() {
        if(temp.isEmpty()){
            while(!pri.isEmpty()){
                temp.push(pri.pop());
            }
        }
        
        return temp.pop();
    }
    
    public int peek() {        
        if(temp.isEmpty()){
            return top;
        }
        
        return temp.peek();
    }
    
    public boolean empty() {
        return pri.isEmpty() && temp.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */