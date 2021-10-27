package Filter;

import Conversations.*;
import FileHandling.Dictionary.Dictionary;
import Filter.Behavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;
import java.util.List;

/**
 * Init with MessageSelector & FilterBehavior Sets the FilterBehavior to our
 * FilterBehavior
 *
 * Receive the conversation Retrieves the messages we need from the conversation
 * Process the Filter() method If true adds the information we need to the
 * conversation Sends the conversation to the 'match; queue
 *
 * If false Send the conversation to the 'noMatch' queue
 */
public class FilterAssistant implements Runnable {

    FilterBehavior fBehavior;
    MessageSelector mSelector;
    FilterManager fManager;
    List<Dictionary> dictionaries;
    
    Conversation currentConversation;
    List<Message> currentMessages;

    public FilterAssistant(FilterBehavior fBehavior,
            MessageSelector mSelector,
            FilterManager fManager,
            List<Dictionary> dictionaries) {
        this.fBehavior = fBehavior;
        this.mSelector = mSelector;
        this.fManager = fManager;
        this.dictionaries = dictionaries;
    }

    @Override
    public void run() {
        try {
            getConversation();
            setMessages();
            for(Dictionary dictionary : this.dictionaries){
                
            }
            
            
            
            
            
        } catch (InterruptedException ex) {
            System.out.println("Error on a Thread");
        }
    }

    private void getConversation() throws InterruptedException {
        this.currentConversation = this.fManager.getConversation();
    }

    private void setMessages() {
        this.currentMessages = this.mSelector.getMessages(currentConversation);
    }

    private void filter() {
        this.fBehavior.filter();
    }
}
