package Filter;

import Conversations.*;
import FileHandling.Dictionary.Dictionary;
import Filter.Behavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

//Gets Inicialized
//Initializes BlockingQueues
//Creates Assistants
//Provides a method for assistants to get messages

public class FilterManager {
    
    List<Dictionary> dictionaries;
    FilterBehavior filterBehavior;
    MessageSelector messageSelector;
    FilterAssistant assistant;
    
    BlockingQueue<Conversation> enteringMessages;
    BlockingQueue<Conversation> matchedMessages;
    BlockingQueue<Conversation> notFoundMessages;
    
    ExecutorService threadPool;
    
    
    //Initializes the 2 Queues we are going to use
    public FilterManager(){
        this.enteringMessages = new LinkedBlockingDeque<>();
        this.matchedMessages = new LinkedBlockingDeque<>();
        this.notFoundMessages = new LinkedBlockingDeque<>();
    }
    
    public void setFilterBehavior(FilterBehavior filterBehavior){
        this.filterBehavior = filterBehavior;
    }
    
    public void setMessageSelector(MessageSelector messageSelector){
        this.messageSelector = messageSelector;
    }
    
    public void setDictionaries(List<Dictionary> dictionaries){
        this.dictionaries = dictionaries;
    }
    
    public void Run(Conversation conversation){
        createAssitants();
    }

    private void createAssitants(){
        //This class does not pass on a conversation
        //The assitants grab the converstion by their own
        //Here we need to have a pool of assitants so they get re-used     
    }
    
    protected Conversation getConversation() throws InterruptedException{
        return this.enteringMessages.poll(100, TimeUnit.MILLISECONDS);
    }
    
    public void addConversationToMatch(Conversation conversation){
        this.matchedMessages.add(conversation);
    }
    
    public void addConversationToNotMatch(Conversation conversation){
        this.notFoundMessages.add(conversation);
    }
}
