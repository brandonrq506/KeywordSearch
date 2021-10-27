
package Filter.Behavior;

import Conversations.Message;
import java.util.List;

public abstract class FilterBehavior {
    
    protected List<Message> messages;
    protected List<String> keywords;
    
    public FilterBehavior(List<Message> messages, List<String> keywords){
        this.messages = messages;
        this.keywords = keywords;
    }
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
    public abstract boolean filter();
}
