public class TestBench {
    public static void main(String[] args) {
        QueueWithStack queue = new QueueWithStack();
        for (int i = 0; i < 32; i++) {
            System.out.println("-------------------------------------");
            queue.enq(i);
            System.out.println(queue.toString());
            System.out.println("-------------------------------------");
            System.out.println();
        }
        for (int i = 0; i < 24; i++) {
            System.out.println("-------------------------------------");
            System.out.println(queue.deq());
            System.out.println(queue.toString());
            System.out.println("-------------------------------------");
            System.out.println();
        }
    }
}
