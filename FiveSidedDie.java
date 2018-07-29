import java.util.*;

public class FiveSidedDie {
    private static int rand7() {
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }

    private static int roll() {
        int pool = 0;
        for (int i = 0; i < 5; i++) {
            pool += rand7();
        }
        return pool % 5;
    }

    public static void main(String[] args) {
        int[] sample = new int[5];
        for (int i = 0; i < 100000; i++) {
            sample[roll()]++;
        }
        System.out.println(Arrays.toString(sample));
    }
}
