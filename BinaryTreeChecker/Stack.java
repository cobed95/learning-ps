public class Stack {
    private int head;
    private int tail;
    private BinaryTreeNode[] stack;

    public Stack(int size) {
        this.tail = 0;
        this.stack = new BinaryTreeNode[size];
    }

    public void push(BinaryTreeNode data) {
        if (!this.isFull()) {
            this.stack[this.tail] = data;
            tail++;
        }
    }

    public BinaryTreeNode pop() {
        if (!this.isEmpty()) {
            this.tail--;
            return this.stack[this.tail];
        } else {
            return null;
        }
    }

    public boolean isFull() {
        return this.tail == this.stack.length;
    }

    public boolean isEmpty() {
        return this.tail == 0;
    }
}
