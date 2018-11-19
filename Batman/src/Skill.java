public class Skill {
    private String name;
    private int offense;
    private int points;
    private Skill require;

    public Skill(String name, int offense, int points, Skill require) {
        this.name = name;
        this.offense = offense;
        this.points = points;
        this.require = require;
    }

    public String getName() {
        return this.name;
    }

    public int getOffense() {
        return this.offense;
    }

    public int getPoints() {
        return this.points;
    }

    public Skill getRequire() {
        return this.require;
    }

    public boolean equals(Object o) {
        if (o instanceof Skill) {
            Skill other = (Skill) o;
            return this.getName().equals(other.getName());
        }
        return false;
    }
}
