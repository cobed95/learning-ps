public class Boss {
    private String name;
    private int hp;

    public Boss(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public boolean isDead(int offense) {
        return this.hp <= offense;
    }
}
