package Display.CustomerFinder;

public class Finder_ADA extends Finder_CustomerName {

    @Override
    public void find(String text) {
        //Make the string start from the last thing bot mentions
        int foundword = text.indexOf("presence message summary") + 27;
        
        if(foundword == 26) {
            foundword = text.indexOf("members. summary") + 18;
        }
        String customer = text.substring(foundword);

        //Now we create the delimitations
        int beginning = customer.indexOf(")") + 2;
        int end = customer.indexOf(":");

        //Now we just cut
        try {
            super.customerName = customer.substring(beginning, end);
        } catch (Exception e) {
            super.customerName = "visitor";
        }
    }

}
