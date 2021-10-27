package Filter;

import Filter.Behavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;

/**
 * Init with MessageSelector & FilterBehavior 
 * Sets the FilterBehavior to our
 * FilterBehavior
 *
 * Receive the conversation 
 * Retrieves the messages we need from the conversation
 * Process the Filter() method If true adds the information we need to the
 * conversation Sends the conversation to the 'match; queue
 *
 * If false Send the conversation to the 'noMatch' queue
 */
public class FilterAssistant implements Runnable {

    FilterBehavior fBehavior;
    MessageSelector mSelector;
    FilterManager fManager;

    public FilterAssistant(FilterBehavior fBehavior,
            MessageSelector mSelector,
            FilterManager fManager) {
        this.fBehavior = fBehavior;
        this.mSelector = mSelector;
        this.fManager = fManager;
    }

    @Override
    public void run() {
        //Get a conversation
        //Get messages for that conversation
        //While loop for all dictionaries
    }
    
    private void getConversation(){
        //FilterManager will have a SYNC method that provides us with converstion
    }
    
    private void setMessages(){
        //We use this in our fBehavior initializer
    }
    
    private void filter(){
        this.fBehavior.filter();
    }
}
