
package Display.CustomerFinder;

public class Finder_iOS extends Finder_CustomerName{

    @Override
    public void find(String text) {
        //Make the string start from the last thing bot mentions
        int foundword = text.indexOf("i make you smile") + 17;
        String customer = text.substring(foundword);
        
        //Now we create the delimitations
        int beginning = customer.indexOf(")") + 2;
        int end = customer.indexOf(":");
        
        //Now we just cut
        try {
            super.customerName = customer.substring(beginning, end);
        } catch (Exception e) {
            findException(text.substring(foundword + 15));
        }
    }
    
    public void findException(String text) {
        //Make the string start from the last thing bot mentions
        String customer = text.substring(text.indexOf("today?") + 7);
        
        //Now we create the delimitations
        int beginning = customer.indexOf(")") + 2;
        int end = customer.indexOf(":");
        
        //Now we just cut
        super.customerName = customer.substring(beginning, end);
    }
}
