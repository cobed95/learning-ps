import java.util.*;

public class Pole {
    private Stack atHere;
   
    public Pole() {
        this.atHere = new Stack();
    }

    public void insert(Disc disc) {
        if (this.atHere.isEmpty() || disc.lt(this.atHere.getTop())) 
            this.atHere.push(disc);
    }

    public Disc pullOut() {
        if (this.atHere.isEmpty()) return null;
        return this.atHere.pop();
    }

    public void moveTo(Pole goal) {
        Disc disc = this.pullOut();
        goal.insert(disc);
    }

    public boolean isEmpty() {
        return this.atHere.isEmpty();
    }

    public String toString() {
        return this.atHere.toString();
    }
}
