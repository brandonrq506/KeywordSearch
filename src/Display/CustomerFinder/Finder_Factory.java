
package Display.CustomerFinder;

public class Finder_Factory {

    public Finder_CustomerName create(String instance){
        switch(instance){
            case "tycas": case "sdc":
                return new Finder_SDC();
            case "tocas": case "udcas": case "marki":
                return new Finder_MarkMolar();
            case "ios": case "msea2":
                return new Finder_iOS();
            case "dtteam":
                return new Finder_DT();
            case "sales":
                return new Finder_Sales();
            case "marki2":
                return new Finder_Marki2();
            case "adabot":
                return new Finder_ADA();
            default:
                return null;
        }
    }
}
