public class StringComparable {
    private String string;
    
    public StringComparable(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
    
    public int compareTo(StringComparable other) {
        int idx = 0;
        while (idx < this.string.length() && idx < other.getString().length() && this.string.charAt(idx) == other.getString().charAt(idx)) {
            idx++;
        }
        if (idx == this.string.length() && idx == other.getString().length()) {
            return 0;
        } else if (idx == this.string.length()) {
            return -1 * other.getString().charAt(idx);
        } else if (idx == other.getString().charAt(idx)) {
            return this.string.charAt(idx);
        } else {
            return this.string.charAt(idx) - other.getString().charAt(idx);
        }
    }
}
