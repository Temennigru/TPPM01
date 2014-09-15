package Sports;

public abstract class Sport {
    protected final int[] points = new int[2];
        
    public Sport() {
        this.points[0] = 0;
        this.points[1] = 0;
    }
        
    public int victor() {
        if (this.points[1] == this.points[0]) {
            return 2;
        } else if (this.points[1] > this.points[0]) {
            return 1;
        } else {
            return 0;
        }
    }
    public void score(int team, int score) { this.points[team] += score; }
    public void score(int team) { this.score(team, 1); }
    public void reset() {
        this.points[0] = 0;
        this.points[1] = 0;
    }
    public abstract String getName();
}
