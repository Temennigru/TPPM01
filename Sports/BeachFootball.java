package Sports;

public class BeachFootball extends Sport {
    @Override
    public int victor() {
        if (this.points[1] == this.points[0]) {
            return 2;
        } else if (this.points[1] > this.points[0]) {
            return 0;
        } else {
            return 1;
        }
    }
    public String getName() { return "Futebol de areia"; }
}