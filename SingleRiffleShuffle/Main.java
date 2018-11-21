public class Main {
    public static void main(String[] args) {
        int[] half1 = {1, 2, 3, 4, 5, 6};
        int[] half2 = {7, 8, 9, 10, 11, 12};
        int[] shuffledDeck1 = {1, 2, 7, 3, 8, 9, 4, 10, 5, 11, 12, 6};
        System.out.println(isSingleRiffle(shuffledDeck1, half1, half2));
        int[] shuffledDeck2 = {1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println(isSingleRiffle(shuffledDeck2, half1, half2));
        int[] shuffledDeck3 = {2,1,6,7,9,10,5,4,11,12,3,8};
        System.out.println(isSingleRiffle(shuffledDeck3, half1, half2));
    }

    public static boolean isSingleRiffle(int[] shuffledDeck, int[] half1, int[] half2) {
        return isRiffleOfHalf(shuffledDeck, half1) && isRiffleOfHalf(shuffledDeck, half2);    
    }

    public static boolean isRiffleOfHalf(int[] shuffledDeck, int[] half) {
        int ptrShuffled = 0;
        int ptrHalf = 0;
        while (ptrHalf < half.length && ptrShuffled < shuffledDeck.length) {
            while (ptrShuffled < shuffledDeck.length 
                    && shuffledDeck[ptrShuffled] != half[ptrHalf]) 
                ptrShuffled++;
            ptrHalf++;
        }
        return ptrHalf == half.length;
    }
}
