import java.util.*;
import edu.duke.*;
import java.io.*;
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LargestQuakes {

    public void findLargestQuakes() {
    
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
                //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        ArrayList<QuakeEntry> largestQuakes = getLargest(list,50);
        for (QuakeEntry quakeEntry : largestQuakes) {
            System.out.println(quakeEntry.toString());
        }
        System.out.println("read data for " + list.size() + " quakes");
        System.out.println(largestQuakes.size() +" quakes found.");
        
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        double highestMag = 0.0;
        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            QuakeEntry quakeEntry = data.get(i);
            if (quakeEntry.getMagnitude() > highestMag) {
                highestMag = quakeEntry.getMagnitude();
                result = i;
            }
        }
        
        return result;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> largest= new ArrayList<QuakeEntry>();
        for (int i = 0; i < howMany; i++) {
            int indexOfLargest = indexOfLargest(quakeData);
            largest.add(quakeData.get(indexOfLargest));
            quakeData.remove(quakeData.get(indexOfLargest));
        }
        
        return largest;
    }
}
