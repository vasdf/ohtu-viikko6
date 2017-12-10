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
//        Matcher m = new And(new HasAtLeast(10, "goals"),
//                            new HasFewerThan(12, "goals")
//        );
        QueryBuilder query = new QueryBuilder();

//        Matcher m = query.playsIn("NYR")
//                         .hasFewerThan(5, "goals")
//                         .hasAtLeast(3, "goals")
//                         .build();
        Matcher m1 = query.playsIn("PHI")
                          .build();

        Matcher m2 = query.hasFewerThan(5, "goals")
                          .build();
        
        Matcher m3 = query.not(m2);

        Matcher m = query.and(m1, m3);

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
