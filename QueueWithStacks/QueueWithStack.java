public class QueueWithStack {
    private Stack in;
    private Stack out;

    public QueueWithStack() {
        this.in = new Stack();
        this.out = new Stack();
    }
    
    public void enq(int data) {
        this.in.push(data);
    }

    public int deq() {
        if (this.out.isEmpty()) {
            while (!this.in.isEmpty()) {
                this.out.push(this.in.pop());
            }
        }
        return this.out.pop();
    }

    public String toString() {
        return "In: " + in.toString() + "\n" + "Out: " + out.toString();
    }
}
