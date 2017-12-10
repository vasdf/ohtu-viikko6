
package statistics;

import java.util.ArrayList;
import java.util.List;
import statistics.matcher.*;

public class QueryBuilder {
    ArrayList<Matcher> matchers;
    
    public QueryBuilder() {
        matchers = new ArrayList();
    }
    
    public Matcher build() { 
        Matcher[] matcherArray = new Matcher[matchers.size()];
        
        int i = 0;
        for (Matcher matcher : matchers) {
            matcherArray[i] = matcher;
            i++;
        }
        
        matchers = new ArrayList();
        return new And(matcherArray);
    }
     
    public Matcher oneOf(Matcher ... matcher) {   
        return new Or(matcher);
    }
    
    QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    } 
}
