import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kilos = scanner.nextInt();
        if (kilos >= 3 && kilos <= 5000) {
            int numOf5 = kilos / 5;
            int remainder = kilos % 5;
            int[] partition = {remainder, 5 * numOf5};
            int[] distributed = distribute(partition);
            int numOfBags = getNumOfBags(distributed);
            System.out.println(numOfBags);
        }
    }
    
    public static int[] distribute(int[] partition) {
        if (partition[1] < 0 || partition[0] % 3 == 0) return partition;
        else {
            partition[0] += 5;
            partition[1] -= 5;
            return distribute(partition);
        }
    }
    
    public static int getNumOfBags(int[] distributed) {
        if (distributed[1] < 0) return -1;
        else return (distributed[0] / 3) + (distributed[1] / 5);
    }
}
