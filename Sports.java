public class Sports {
    private abstract class Sport {
        protected int[] points = new int[2];
        this.points[0] = 0;
        this.points[1] = 0;
        
        public int victor() {
            if (this.points[1] == this.points[0]) {
                return 2;
            } else if (this.points[1] > this.points[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        public void score(int team) { this.score(team, 1); }
        public void score(int team, int score) { this.points[team] += score; }
    }

    public class Basquetball extends Sport {
        public Basquetball() {}
    }
    
    public class IndoorVolleyBall extends Sport {
        public IndoorVolleyBall() {}
    }

    public class BeachVolleyball extends Sport {
        public BeachVolleyball() {}
        public int victor() {
            if (this.points[1] == this.points[0]) {
                return 2;
            } else if (this.points[1] > this.points[0]) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public class FieldFootball extends Sport {
        public FieldFootball() {}
    }

    public class BeachFootball extends Sport {
        public BeachFootball() {}
        public int victor() {
            if (this.points[1] == this.points[0]) {
                return 2;
            } else if (this.points[1] > this.points[0]) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public class IndoorFootball extends Sport {
        public IndoorFootball() {}
    }
}