
package Filter.MessageSelector;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public class MessagesBySender extends MessageSelector{
    
    public MessagesBySender(int[] senders){
        super.senders = senders;
    }

    @Override
    public List<Message> getMessages(Conversation conversation) {
        return conversation.getMessagesBySender(super.senders);
    }
    
}
