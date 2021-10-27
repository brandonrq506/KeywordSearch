
package Filter.MessageSelector;

import Conversations.*;
import java.util.List;

public abstract class MessageSelector {
    
    public abstract List<Message> getMessages(Conversation conversation);
}
