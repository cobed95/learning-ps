import java.util.*;

public class ParenthesesMatcher {
    private static class Stack {
        private int ptr;
        private int[] stack;

        public Stack(int size) {
            this.ptr = 0;
            this.stack = new int[size];
        }

        public void push(int data) {
            if (!this.isFull()) {
                this.stack[this.ptr] = data;
                this.ptr++;
            }
        }

        public int pop() {
            if (!this.isEmpty()) {
                this.ptr--;
                return this.stack[this.ptr];
            }
            System.out.println("Exception: popping from empty stack. Handled by returning -1");
            return -1;
        }

        public boolean isEmpty() {
            return this.ptr == 0;
        }

        public boolean isFull() {
            return this.ptr == this.stack.length;
        }
    }

    private static int matchParenthesis(String input, int idx) {
        Stack stack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
                System.out.println("Pushed " + i + ".");
            } else if (input.charAt(i) == ')') {
                int open = stack.pop();
                System.out.println("Popped " + open + " at " + i + ".");
                if (open == idx) {
                    return i;
                }
            }
        }
        System.out.println("Exception: could not find matching parenthesis with idx " + idx + ". Handled by returning -1");
        return -1;
    }
    
    public static void main(String[] args) {
        String input = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        int idx = 57;
        System.out.println(matchParenthesis(input, idx));
    }
}
