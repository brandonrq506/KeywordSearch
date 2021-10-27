
package Filter;

import Conversations.Conversation;
import FileHandling.Dictionary.*;

public abstract class Filter{
    
    protected DictionaryHolder dicHolder;
    protected Conversation currentConversation;
    protected Dictionary currnetDictionary;
    
    
    public Filter(DictionaryHolder dicHolder){
        this.dicHolder = dicHolder;
    }
    
    public void setDictionaryHolder(DictionaryHolder dicHolder){
        this.dicHolder = dicHolder;
    }
    
    public void setConversation(Conversation conversation){
        this.currentConversation = conversation;
    }
    
    protected abstract boolean filter();
}
