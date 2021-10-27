
package Filter.MessageSelector;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public class MessagesBySender extends MessageSelector{

    @Override
    public List<Message> getMessages(Conversation conversation) {
        return conversation.getMessagesBySender(super.senders);
    }
    
}
