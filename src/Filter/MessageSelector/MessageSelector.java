
package Filter.MessageSelector;

import Conversations.*;
import java.util.List;

public abstract class MessageSelector {
    
    protected int[] senders;
    protected int nMessages;

    public abstract List<Message> getMessages(Conversation conversation);
}
