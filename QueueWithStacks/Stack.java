import java.util.*;

public class Stack {
    private int[] stack;
    private int tail;
    
    public Stack() {
        this.stack = new int[2];
        this.tail = 0;
    }

    public boolean isEmpty() {
        return this.tail == 0;
    }

    private void extend() {
        int[] newStack = new int[this.stack.length * 2];
        for (int i = 0; i < this.stack.length; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }

    private void shrink() {
        int[] newStack = new int[this.stack.length / 2];
        for (int i = 0; i < newStack.length; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }

    public void push(int data) {
        this.stack[this.tail] = data;
        this.tail++;
        if (this.tail == this.stack.length) {
            this.extend();
        }
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

    public String toString() {
        return Arrays.toString(this.stack);
    }
}
