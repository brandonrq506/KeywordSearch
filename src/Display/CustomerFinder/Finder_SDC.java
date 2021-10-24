
package Display.CustomerFinder;

public class Finder_SDC extends Finder_CustomerName{

    @Override
    public void find(String text) {
        //Make the string start from the last thing bot mentions
        String customer = text.substring(text.indexOf("phone number.") + 14);
        
        //Now we create the delimitations
        int beginning = customer.indexOf(")") + 2;
        int end = customer.indexOf(":");
        
        //Now we just cut
        super.customerName = customer.substring(beginning, end);
    }
}
