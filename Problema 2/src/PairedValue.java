public class PairedValue implements Comparable<PairedValue> {

    int a1;
    int a2;
    double a3;

    public PairedValue(int a1, int a2, double a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public int compareTo(PairedValue o) {
        if (this.a3 > o.a3) {
            return 1;
        } else if (this.a3 < o.a3) {
            return -1;
        } else {
            return 0;
        }
    }
}
