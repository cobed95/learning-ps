public class Queue {
    private int head;
    private int tail;
    private NodeWithDepth[] queue;

    public Queue(int size) {
        this.head = 0;
        this.tail = 0;
        this.queue = new NodeWithDepth[size];
    }
    
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return (this.head == 0 && this.tail == this.queue.length - 1) || this.tail == this.head - 1;
    }

    public void push(NodeWithDepth node) {
        if (!this.isFull()) {
            this.queue[this.tail] = node;
            if (this.tail == this.queue.length - 1) {
                this.tail = 0;
            } else {
                this.tail++;
            }
        }
    }

    public NodeWithDepth pop() {
        if (!this.isEmpty()) {
            if (this.head == this.queue.length - 1) {
                this.head = 0;
                return this.queue[this.queue.length - 1];
            } else {
                this.head++;
                return this.queue[this.head - 1];
            }
        }
        return null;
    }
}
