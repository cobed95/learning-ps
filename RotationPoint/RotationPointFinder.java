public class RotationPointFinder {
    private static int findRotationPoint(StringComparable[] words) {
        int lower = findRotationPoint(words, 0, words.length, true);
        if (lower != -1) {
            return lower;
        } else {
            int upper = findRotationPoint(words, 0, words.length, false);    
            return upper;
        }
    }

    private static int findRotationPoint(StringComparable[] words, int start, int end, boolean isLower) {
        int mid = (start + end) / 2;       
        if (isLower) {
            return findRotationPoint(words, start, mid, mid);
        } else {
            return findRotationPoint(words, mid, end, mid);
        } 
    }

    private static int findRotationPoint(StringComparable[] words, int start, int end, int standard) {
        return 0; 
    }

    public static void main(String[] args) {
        String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote",
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage"
        };
    }
}
