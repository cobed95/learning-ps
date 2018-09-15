public class TowerOfHanoi {
    public static void TowerOfHanoi(Pole source, Pole temp, Pole goal) {
        System.out.println(source.toString());
        System.out.println(temp.toString());
        System.out.println(goal.toString());
        System.out.println("--------------------------------------------");

        if (!source.isEmpty()) {
            TowerOfHanoi(source, goal, temp);
            source.moveTo(goal);
            TowerOfHanoi(temp, source, goal);
        }
    }

    public static void main(String[] args) {
        Pole source = new Pole();
        Pole temp = new Pole();
        Pole goal = new Pole();

        for (int i = 10; i > 0; i--) {
            source.insert(new Disc(i));
        }

        TowerOfHanoi(source, temp, goal);
    }
}
