public class Main {
    public static void main(String[] args) {

    }

    public static Pair<Integer, Integer> getPairThatSumK(int[] array, int k) {
        sort(array);
        
        int p = 0;
        int q = array.length - 1;
        while (p < q && array[p] + array[q] != k) {
            int sum = array[p] + array[q];
            if (sum < k) p++;
            else q--;
        }
        
        if (p < q) return new Pair<Integer, Integer>(array[p], array[q]);
        else return new Pair<Integer, Integer>(-1, -1);
    }
}
