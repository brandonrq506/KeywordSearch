
package Display.Bot;

import Conversations.Message;
import java.util.List;

public interface IDisplay_BotChat {
    
    public void process(String text);
    
    public void setArray(List<Message> messages);
    
    public void setConfig(List<Message> messages, String cusName, int[] senders);
}