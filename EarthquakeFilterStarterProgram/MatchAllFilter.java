import java.util.*;
import java.io.*;
/**
 * Write a description of MathAllFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filters;
    public MatchAllFilter (){
        filters = new ArrayList<Filter>();
    }
    public void addFilter(Filter f) {
        filters.add(f);
    }
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f: filters) {
            if (!f.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }
        public String getName() {
            String nameList = "Filters used are: ";
            for (Filter f: filters) {
             nameList += f.getName() + " ";   
            }
        return nameList;
    }

}
