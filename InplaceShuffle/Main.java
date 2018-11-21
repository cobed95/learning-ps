// {a1, a2, a3, ... , an};
// f(x): swap
// FinalPos = f(f(x))
// P(f(x) = X) = 1/(n - x - 1)
// P(f(f(x)) = X) = 

import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,0};
        shuffle(array);  
        System.out.println(Arrays.toString(array));
    }

    public static <E> void shuffle(E[] array) {
        for (int i = 0; i < array.length; i++) {
            int rand = getRandom(i, array.length - 1);
            swap(array, i, rand);
        }  
    }

    public static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int getRandom(int lower, int upper) {
        Random random = new Random();
        int bound = upper + 1 - lower;
        return lower + random.nextInt(bound);
    }
}
