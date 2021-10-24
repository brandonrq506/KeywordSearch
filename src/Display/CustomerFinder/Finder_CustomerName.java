
package Display.CustomerFinder;

public abstract class Finder_CustomerName {
    
    protected String customerName;
    
    public abstract void find(String text);
    
    public String getCustomerName(){
        return this.customerName;
    }
}
