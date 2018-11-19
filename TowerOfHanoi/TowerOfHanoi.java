public class TowerOfHanoi {
    public static void TowerOfHanoi(int max, Pole source, Pole temp, Pole goal) {
        if (goal.getLength() < max) {
            System.out.println(source.toString());
            System.out.println(temp.toString());
            System.out.println(goal.toString());
            System.out.println("--------------------------------------------");

            TowerOfHanoi(max, source, goal, temp);
            source.moveTo(goal);
            TowerOfHanoi(max, temp, source, goal);
        }
    }

    public static void main(String[] args) {
        /*
        Pole source = new Pole();
        Pole temp = new Pole();
        Pole goal = new Pole();

        for (int i = 10; i > 0; i--) {
            source.insert(new Disc(i));
        }

        TowerOfHanoi(10, source, temp, goal);
        */

        Pole source = new Pole();
        Pole goal = new Pole();
        source.insert(new Disc(1));
        System.out.println(source.toString());
        System.out.println(goal.toString());
        source.moveTo(goal);
        System.out.println(source.toString());
        System.out.println(goal.toString());
    }
}
