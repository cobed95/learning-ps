import java.util.*;

public class Disc {
    private int size;
    
    public Disc(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public boolean gt(Disc other) {
        if (this.size > other.getSize()) {
            return true;
        }
        return false;
    }

    public boolean lt(Disc other) {
        if (this.size < other.getSize()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Integer.toString(this.size);
    }
}
