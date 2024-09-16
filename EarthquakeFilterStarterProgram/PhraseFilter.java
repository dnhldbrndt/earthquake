
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    private String request;
    private String phrase;
    public PhraseFilter (String req, String ph) {
        request = req;
        phrase = ph;
    }
    public boolean satisfies (QuakeEntry qe) {
       
            if (request.equalsIgnoreCase("start") && qe.getInfo().startsWith(phrase)) {
                return true;
            }
            else if (request.equalsIgnoreCase("ends") && qe.getInfo().endsWith(phrase)) {
                return true;
            }
            else if (request.equalsIgnoreCase("any") && qe.getInfo().contains(phrase)) {
                return true;
            }
        
        return false;
    }
        public String getName() {
        return "Phrase";
    }
}
