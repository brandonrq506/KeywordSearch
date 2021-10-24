
package Filter;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public interface IFilter {
    
    boolean filter();
    
    void setMessages(List<Message> messages);
    
    void setKeywords(List<String> filters);
    
    void setSenders(int [] senders);

    public boolean processFilter(Conversation chat);
}
