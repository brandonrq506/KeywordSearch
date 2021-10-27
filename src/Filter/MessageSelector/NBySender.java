
package Filter.MessageSelector;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public class NBySender extends MessageSelector{

    @Override
    public List<Message> getMessages(Conversation conversation) {
        return conversation.getNMessagesBySender(super.senders, super.nMessages);
    }
    
}
