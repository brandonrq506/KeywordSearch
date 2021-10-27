
package Filter;

import Conversations.Message;
import Filter.FilterBehavior.FilterBehavior;
import java.util.List;

public abstract class FilterAssistant {
    
    protected List<Message> messages;
    protected List<String> keywords;
    protected FilterBehavior filterBehavior;
    
    public FilterAssistant(FilterBehavior filterBehavior){
        this.filterBehavior = filterBehavior;
    }

    public void setKeywords(List<String> keywords){
        this.keywords = keywords;
    }
    
    public void setMessages(List<Message> messages){
        this.messages = messages;
    }
    
    public abstract boolean filter();
}
