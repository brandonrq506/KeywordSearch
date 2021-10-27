
package Filter;

import Conversations.*;
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
    
    public void Run(Conversation conversation){
        createAssitant();
        this.assistant.setMessages(getMessages(conversation));
    }
    
    private List<Message> getMessages(Conversation conversation){
        return this.messageSelector.getMessages(conversation);
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
