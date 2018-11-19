import java.util.*;

public class Stack {
    private Disc[] stack;
    private int tail;

    public Stack() {
        this.stack = new Disc[2];
        this.tail = 0;
    }

    public void push(Disc disc) {
        if (this.isFull()) {
            this.expand();
        }
        this.stack[this.tail] = disc;
        this.tail++;
    }

    public Disc pop() {
        if (this.isEmpty()) {
            return null;
        } else if (this.canBeShrunk()) {
            this.shrink();
        } 
        this.tail--;
        return this.stack[this.tail];
    }

    public boolean isFull() {
        if (this.tail == this.stack.length) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.tail == 0) {
            return true;
        }
        return false;
    }

    private boolean canBeShrunk() {
        return this.tail < this.stack.length;
    }

    private void expand() {
        Disc[] newArray = new Disc[this.stack.length * 2];
        for (int i = 0; i < this.stack.length; i++) {
            newArray[i] = this.stack[i];
        }
        this.stack = newArray;
    }

    private void shrink() {
        Disc[] newArray = new Disc[this.stack.length / 2];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.stack[i];
        }
        this.stack = newArray;
    }

    public Disc getTop() {
        return this.stack[this.tail - 1];
    }

    public int getLength() {
        return this.tail;
    }

    public String toString() {
        String result = "[";
        if (this.isEmpty()) return result + "]";
        else {
            result += this.stack[0];
            for (int i = 1; i < this.tail; i++) {
                result += ", ";
                result += this.stack[i];
            }
            return result + "]";
        }
    }
}

