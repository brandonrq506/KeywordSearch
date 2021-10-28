
package Filter.MessageSelector;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public class NBySender extends MessageSelector{

    public NBySender(int[] senders, int nMessages) {
        super.senders = senders;
        super.nMessages = nMessages;
    }

    @Override
    public List<Message> getMessages(Conversation conversation) {
        return conversation.getNMessagesBySender(super.senders, super.nMessages);
    }
    
}
