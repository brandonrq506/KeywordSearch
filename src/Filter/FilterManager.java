
package Filter;

import Conversations.Message;
import FileHandling.Dictionary.Dictionary;
import Filter.FilterBehavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;
import java.util.List;

public class FilterManager {
    
    List<Dictionary> dictionaries;
    FilterBehavior filterBehavior;
    MessageSelector messageSelector;
    FilterAssistant assistant;
    
    public void setFilterBehavior(FilterBehavior filterBehavior){
        this.filterBehavior = filterBehavior;
    }
    
    public void setMessageSelector(MessageSelector messageSelector){
        this.messageSelector = messageSelector;
    }
    
    public void Run(){
        createAssitant();
        this.assistant.setMessages(getMessages());
    }
    
    private List<Message> getMessages(){
        
    }
    
    private boolean Filter(){
        for (Dictionary dic : this.dictionaries){
            this.assistant.setKeywords(dic.getKeywords());
            if(this.assistant.Filter()) {
                //Assing additional column with keyword and file name
            }
        }
    }
    
    private void createAssitant(){
        if (this.assistant == null)
            this.assistant = new FilterAssistant(filterBehavior);
    }
}
