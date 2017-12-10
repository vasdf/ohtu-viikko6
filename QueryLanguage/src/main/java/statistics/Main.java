package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
        
//        Matcher m = new Not(new HasAtLeast(1, "goals"));
//        Matcher m = new Or( new HasAtLeast(40, "goals"),
//                            new HasAtLeast(60, "assists"),
//                            new HasAtLeast(85, "points")    
//        );

//       Matcher m = new HasFewerThan(0, "goals");

        Matcher m = new And(new Not(new HasAtLeast(2, "goals")), 
                            new HasFewerThan(3, "assists"),
                            new HasFewerThan(4, "points")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
