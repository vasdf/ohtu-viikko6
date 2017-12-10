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
                          .hasAtLeast(10, "goals")
                          .hasFewerThan(20, "assists")
                          .build();

        Matcher m2 = query.playsIn("EDM")
                          .hasAtLeast(60, "points")
                          .build();

        Matcher m = query.oneOf(m1, m2);

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
