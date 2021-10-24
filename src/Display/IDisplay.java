
package Display;

import Conversations.Message;
import java.util.List;

public interface IDisplay {
    
    void process(String text);
    
    void setArray(List<Message> messages);

}
