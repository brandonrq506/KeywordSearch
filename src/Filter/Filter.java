
package Filter;

import Conversations.Conversation;
import Conversations.Message;
import java.util.List;

public abstract class Filter implements IFilter{
    
    protected List<Message> messages;
    protected List<String> keywords;
    protected int[] senders;
    
    @Override
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    @Override
    public void setKeywords(List<String> keywords){
        this.keywords = keywords;
    }
    
    @Override
    public void setSenders(int[] senders){
        this.senders = senders;
    }
    
    @Override
    public boolean processFilter(Conversation conversation){
        if(conversation.getMessagesCount() == 0) return false;
        else if(senders[0] == -1) this.messages = conversation.getAllMessages();
        else                      this.messages = conversation.getMessages(senders);
        return filter();
    }
}
