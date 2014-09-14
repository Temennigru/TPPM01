public class Sports {
    private abstract class Sport {
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
    }

    public class Basketball extends Sport {}
    
    public class IndoorVolleyBall extends Sport {}
    
    public class IndoorFootball extends Sport {}
    
    public class FieldFootball extends Sport {}

    public class BeachVolleyball extends Sport {
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
    }

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
    }

}
