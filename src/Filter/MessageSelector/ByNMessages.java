
package Filter.MessageSelector;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public class ByNMessages extends MessageSelector{

    @Override
    public List<Message> getMessages(Conversation conversation) {
        return conversation.getNMessages(super.nMessages);
    }
    
}
