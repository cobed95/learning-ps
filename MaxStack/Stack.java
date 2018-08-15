public class Stack {
    private int[] stack;
    private int tail;

    public Stack() {
        this.stack = new int[2];
        this.tail = 0;
    }

    private void extend() {
        int[] extended = new int[this.stack.length * 2];
        for (int i = 0; i < this.stack.length; i++) {
            extended[i] = this.stack[i];
        }
        this.stack = extended;
    }

    private void shrink() {
        int[] shrunk = new int[this.stack.length / 2];
        for (int i = 0; i < shrunk.length; i++) {
            shrunk[i] = this.stack[i];
        }
        this.stack = shrunk;
    }

    public void push(int data) {
        if (this.tail == this.stack.length) {
            this.extend();
        }
        this.stack[this.tail] = data;
        this.tail++;
    }

    public int pop() {
        if (this.tail == 0) {
            return -1;
        }
        this.tail--;
        if (this.tail < this.stack.length / 2) {
            this.shrink();
        }
        return this.stack[this.tail];
    }
}
