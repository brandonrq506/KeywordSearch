package Filter;

import Conversations.*;
import FileHandling.Dictionary.Dictionary;
import Filter.Behavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;
import java.util.List;

public class FilterAssistant  {

    FilterBehavior fBehavior;
    MessageSelector mSelector;
    FilterManager fManager;
    List<Dictionary> dictionaries;

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

    public boolean filter(Conversation conversation) {
        //Once we get a conversation, we:
        
        //Get the messages we need out of that conversation
        //We set those as our current messages
        this.currentMessages = this.mSelector.getMessages(conversation);
        
        //We assign those messages to our filterBehavior
        this.fBehavior.setMessages(currentMessages);
        
        //For ever dictionary we explore, we update keywords
        for (Dictionary dictionary : this.dictionaries){
            this.fBehavior.setKeywords(dictionary.getKeywords());
            
            
            //Once our filterBehavior is loaded with the messages and keywords we want:
            if (this.fBehavior.filter()) {
                conversation.addAdditionalColumn(this.fBehavior.getKeyword());
                conversation.addAdditionalColumn(dictionary.getTextFileName());
                return true;
            }
        }
        return false;
    }
}
