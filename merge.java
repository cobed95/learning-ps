import java.util.*;

public class merge {
    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        for (int k = 0; k < left.size() + right.size(); k++) {
            if (i < left.size() && j < right.size() && left.get(i) <= right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else if (i < left.size() && j < right.size() && left.get(i) > right.get(j)) {
                merged.add(right.get(j));
                j++;
            } else if (i >= left.size() && j < right.size()) {
                merged.add(right.get(j));
                j++;
            } else if (i < left.size() && j >= right.size()) {
                merged.add(left.get(i));
                i++;
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        int leftSize = scanner.nextInt();
        for (int i = 0; i < leftSize; i++) {
            int leftElement = scanner.nextInt();
            left.add(leftElement);
        }
        int rightSize = scanner.nextInt();
        for (int j = 0; j < leftSize; j++) {
            int rightElement = scanner.nextInt();
            right.add(rightElement);
        }

        ArrayList<Integer> mergedList = merge(left, right); 
        
        System.out.println(mergedList);
    }
}
