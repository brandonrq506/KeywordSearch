package Filter;

import Conversations.*;
import FileHandling.Dictionary.Dictionary;
import Filter.Behavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;
import java.util.LinkedList;
import java.util.List;

public class FilterManager {

    //This is all for our Assistants
    private List<Dictionary> dictionaries;
    private FilterBehavior filterBehavior;
    private MessageSelector messageSelector;
    private FilterAssistant assistant;

    List<Conversation> match;
    List<Conversation> noMatch;

    
    public FilterManager() {
        this.match = new LinkedList<>();
        this.noMatch = new LinkedList<>();
    }
    
    public void Filter(Conversation conversation){
        boolean passed = assistant.filter(conversation);
        
        if (passed) this.match.add(conversation);
        else this.noMatch.add(conversation);
    }

    public void createFilterAssistant() {
        this.assistant = new FilterAssistant(filterBehavior, messageSelector, this, dictionaries);
    }

    public void setFilterBehavior(FilterBehavior filterBehavior) {
        this.filterBehavior = filterBehavior;
    }

    public void setMessageSelector(MessageSelector messageSelector) {
        this.messageSelector = messageSelector;
    }

    public void setDictionaries(List<Dictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }

    protected void addToMatch(Conversation conversation) {
        this.match.add(conversation);
    }

    protected void addToNoMatch(Conversation conversation) {
        this.noMatch.add(conversation);
    }
    
    public List<Conversation> getMatchList(){
        return this.match;
    }
    
    public List<Conversation> getNoMatchList(){
        return this.noMatch;
    }
}
