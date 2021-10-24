
package Display.Bot;

public class DisplayBot_Factory {
    
    public IDisplay_BotChat create(String instance){
        switch(instance){
            case "tycas":
                return new Display_SDCBot();
            case "tocas": case "udcas":
                return new Display_MarkMolar();
            default:
                return null;
        }
    }
}
