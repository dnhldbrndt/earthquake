
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    public int getLargestDepth (ArrayList<QuakeEntry> quakeData, int from){
        int maxIndex = from;
        for (int i = from+1; i < quakeData.size(); i++) {
            if (quakeData.get(i).getDepth() > quakeData.get(maxIndex).getDepth()) {
                maxIndex = i;
            }
        }
        
        
        return maxIndex;
    }
    public void sortByLargestDepth (ArrayList<QuakeEntry> in) {
        //sorts the QuakeEntry's in the ArrayList by depth using the selection sort algorithm   
        for (int i = 0; i < in.size(); i++ ) {
            int maxIndex = getLargestDepth(in,i);
            QuakeEntry currentQuakeEntry = in.get(i);
            QuakeEntry quakeMax = in.get(maxIndex);
            in.set(i,quakeMax);
            in.set(maxIndex,currentQuakeEntry);
        }
    }
        public void sortByLargestDepth (ArrayList<QuakeEntry> in, int numberOfPasses) {
        //sorts the QuakeEntry's in the ArrayList by depth using the selection sort algorithm   
        for (int i = 0; i < numberOfPasses; i++ ) {
            int maxIndex = getLargestDepth(in,i);
            QuakeEntry currentQuakeEntry = in.get(i);
            QuakeEntry quakeMax = in.get(maxIndex);
            in.set(i,quakeMax);
            in.set(maxIndex,currentQuakeEntry);
        }
    }
    public void onePassBubbleSort (ArrayList<QuakeEntry> quakeData, int numSorted) {
        for (int i = 0; i < numSorted; i++) {
            if (quakeData.get(i+1).getMagnitude() < quakeData.get(i).getMagnitude()) {
                QuakeEntry nextEntry = quakeData.get(i+1);
                QuakeEntry currentEntry = quakeData.get(i);
                quakeData.set(i+1,currentEntry);
                quakeData.set(i,nextEntry);
            }
        }
    }
    public void sortByMagnitudeWithBubbleSort (ArrayList<QuakeEntry> in) {
        int passNumber = 0;
        for (int i = in.size()-1; i > 0; i--) {
            onePassBubbleSort(in, i);
                    System.out.println("Printing Quakes after pass " + passNumber);
            for (QuakeEntry qe : in) {
             System.out.println(qe);   
            }
            passNumber++;
        }
        System.out.println("---");
    }
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes) {
        for (int i = 0; i < quakes.size()-1; i++) {
            if (quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()) {
                   return false;
            }
        }
        return true;
    }
    public void sortByMagnitudeWithBubbleSortWithCheck (ArrayList<QuakeEntry> in) {
        int numberOfPasses = 0;
        for (int i = in.size()-1; i> 0; i--) {
            onePassBubbleSort(in, i);
            numberOfPasses++;
            if (checkInSortedOrder(in)) {
                break;
            }
        }
        System.out.println("Number of passes to sort: "+ numberOfPasses);
    }
    public void sortByMagnitudeWithCheck (ArrayList<QuakeEntry> in) {
        int numberOfPasses = 0;
        for(int i= 0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            numberOfPasses++;
            if (checkInSortedOrder(in)) {
                break;
            }
        }
        System.out.println("Number of passes needed: " + numberOfPasses);
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        
        String source = "data/earthquakeDataSampleSix1.atom";
        //String source = "data/earthquakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        ArrayList<QuakeEntry> list2  = parser.read(source);  
        ArrayList<QuakeEntry> list3  = parser.read(source);  
        ArrayList<QuakeEntry> list4  = parser.read(source);  
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        System.out.println("Sort By Magnitude with Bubble Sort");
        sortByMagnitudeWithBubbleSort(list);
        System.out.println("Sort By Magnitude with Bubble Sort with Check");
        sortByMagnitudeWithBubbleSortWithCheck(list2);
        System.out.println("Sort By Magnitude with Check");
        sortByMagnitudeWithCheck(list3);
        System.out.println("---");
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
                System.out.println("---");
        for (QuakeEntry qe: list2) { 
            System.out.println(qe);
        } 
                System.out.println("---");
        for (QuakeEntry qe: list3) { 
            System.out.println(qe);
        } 
        
    }
    public void testSort3() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        String source2 = "data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
        ArrayList<QuakeEntry> list2  = parser.read(source2);  
        System.out.println("Sort By Magnitude with Check");
        sortByMagnitudeWithCheck(list);
        System.out.println("Sort By Magnitude with Bubble Sort with Check");
        sortByMagnitudeWithBubbleSortWithCheck(list2);
    }
        public void testSort2() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        
        String source = "data/earthquakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
  
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        sortByLargestDepth(list, 70);
        System.out.println("Sort by Largest Depth:"); 
        System.out.println("---");
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
            
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
}
