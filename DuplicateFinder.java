import java.util.*;

public class DuplicateFinder {
    private static int getLoopSize(int[] array) {
        int n = array.length - 1;
        int ptr = n;
        for (int i = 0; i < n + 5; i++) {
            ptr = array[ptr] - 1;
        }
        
        int singleCyclePtr = ptr;
        int doubleCyclePtr = ptr; 
        singleCyclePtr = array[singleCyclePtr] - 1;
        doubleCyclePtr = array[doubleCyclePtr] - 1;
        doubleCyclePtr = array[doubleCyclePtr] - 1;
        int loopLength = 1;
        while (array[singleCyclePtr] != array[doubleCyclePtr]) {
            singleCyclePtr = array[singleCyclePtr] - 1;
            doubleCyclePtr = array[doubleCyclePtr] - 1;
            doubleCyclePtr = array[doubleCyclePtr] - 1;
            loopLength++;
        }
        return loopLength;
    }

    private static int findDuplicate(int[] array) {
        int loopSize = getLoopSize(array);
        int ptr1 = array.length - 1;
        int ptr2 = ptr1;
        for (int i = 0; i < loopSize; i++) {
            ptr2 = array[ptr2] - 1;
        }
        
        while (array[ptr1] != array[ptr2]) {
            ptr1 = array[ptr1] - 1;
            ptr2 = array[ptr2] - 1;
        }
        return array[ptr1];
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 4, 3, 1, 7, 4, 6, 8, 2};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Duplicate: " + findDuplicate(array));
    }
}
