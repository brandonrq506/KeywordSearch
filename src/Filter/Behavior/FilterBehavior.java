
package Filter.Behavior;

import Conversations.Message;
import java.util.List;

public abstract class FilterBehavior {
    
    protected List<Message> messages;
    protected List<String> keywords;
    private String keyword;
    
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
    protected void setKeyword(String keyword){
        this.keyword = keyword;
    }
    
    public String getKeyword(){
        return this.keyword;
    }
    
    public abstract boolean filter();
}
