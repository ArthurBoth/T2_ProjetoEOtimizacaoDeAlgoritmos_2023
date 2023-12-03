public class PairedValue implements Comparable<PairedValue> {

    int weight;
    int value;
    
    public PairedValue(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    
    public int compareTo(PairedValue other) {
        double thisRatio = ((double) this.value) / this.weight;
        double otherRatio = ((double) other.value) / other.weight;

        if (thisRatio > otherRatio) {
            return 1;
        } else if (thisRatio < otherRatio) {
            return -1;
        } else {
            return 0;
        }
    }
}
