public class MaxStack {
    private Stack stack;
    private int max;

    public MaxStack() {
        this.stack = new Stack();
    }

    public void push(int data) {
        this.stack.push(data);
        if (data > this.max) {
            this.max = data;
        }
    }

    public int pop() {
        return this.stack.pop();
    }

    public int getMax() {
        return this.max;        
    }
}
