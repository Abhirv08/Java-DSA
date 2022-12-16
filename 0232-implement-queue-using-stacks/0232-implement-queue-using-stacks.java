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
        pri.push(x);
        if(top == -1){
            top = x;
        }
    }
    
    public int pop() {
        while(!pri.isEmpty()){
            temp.push(pri.pop());
        }
        
        int num = temp.pop();
        if(!temp.isEmpty()){
            top = temp.peek();
        }else{
            top = -1;
        }
        
        while(!temp.isEmpty()){
            pri.push(temp.pop());
        }
        
        return num;
    }
    
    public int peek() {        
        return top;
    }
    
    public boolean empty() {
        return pri.isEmpty();
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