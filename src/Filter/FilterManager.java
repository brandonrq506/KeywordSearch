package Filter;

import Conversations.*;
import FileHandling.Dictionary.Dictionary;
import Filter.Behavior.FilterBehavior;
import Filter.MessageSelector.MessageSelector;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class FilterManager {

    //This is all for our Assistants
    private List<Dictionary> dictionaries;
    private FilterBehavior filterBehavior;
    private MessageSelector messageSelector;
    private FilterAssistant assistant;

    //This is our responsability
    private final BlockingQueue<Conversation> enteringMessages;
    private final BlockingQueue<Conversation> matchedMessages;
    private final BlockingQueue<Conversation> notFoundMessages;

    //This is just to handle our threads
    private final ExecutorService threadPool;
    private static final int ASSISTANTS = 10;

    //Initializes the 2 Queues we are going to use
    public FilterManager() {
        this.enteringMessages = new LinkedBlockingDeque<>();
        this.matchedMessages = new LinkedBlockingDeque<>();
        this.notFoundMessages = new LinkedBlockingDeque<>();
        threadPool = Executors.newCachedThreadPool();
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

    public void Run(Conversation conversation) {
        createAssitants();
        //I create assistants before entering the while(exread.hasNext) loop
        //while in the exread loop the assistants will handle the requests
        //Once over, ex.write will just get a copy of the queues
    }

    private void createAssitants() {
        for (int i = 0; i < ASSISTANTS; i++) {
            this.threadPool.submit(new FilterAssistant(
                    this.filterBehavior,
                    this.messageSelector,
                    this,
                    this.dictionaries
            ));
        }
    }

    protected Conversation getConversation() throws InterruptedException {
        return this.enteringMessages.poll(100, TimeUnit.MILLISECONDS);
    }

    public void addConversationToMatch(Conversation conversation) {
        this.matchedMessages.add(conversation);
    }

    public void addConversationToNotMatch(Conversation conversation) {
        this.notFoundMessages.add(conversation);
    }
}
