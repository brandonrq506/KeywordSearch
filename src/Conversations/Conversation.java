package Conversations;

import Display.IDisplay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conversation {

    private IDisplay displayMethod;

    private final List<Message> messages;
    private final List<String> additionalColums;

    private String transcriptId;
    private String disposition;

    public Conversation() {
        messages = new ArrayList<>();
        additionalColums = new ArrayList();
    }

    public void transform(List<String> columns) {
        transcriptId = columns.get(0);
        try {
            handleDisplay(columns.get(1).toLowerCase());
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Issue on: " + transcriptId);
        }
        disposition = columns.get(2);
        if (columns.size() > 3) {
            fillAdditionalColumns(columns);
        }
    }

    private void handleDisplay(String cellText) {
        String chat = cellText.replaceAll(":\\)", "");
        this.displayMethod.setArray(messages);
        this.displayMethod.process(chat);
    }

    public int getMessagesCount() {
        return this.messages.size();
    }

    public void addMessages(List<Message> messages) {
        this.messages.addAll(messages);
    }

    public String getDisposition() {
        return this.disposition;
    }

    public String getTranscriptId() {
        return transcriptId;
    }

    public void setDisplayMethod(IDisplay displayMethod) {
        this.displayMethod = displayMethod;
    }

    public List<String> getAdditionalColumns() {
        return this.additionalColums;
    }
    
    private void fillAdditionalColumns(List<String> columns) {
        Iterator<String> iterator = columns.listIterator(3);
        while (iterator.hasNext()) {
            additionalColums.add(iterator.next());
        }
    }
    
    public void addAdditionalColumn(String info){
        this.additionalColums.add(info);
    }

    public List<Message> getAllMessages() {
        return this.messages;
    }

    public List<Message> getMessagesBySender(int[] senders) {
        List<Message> temp = new ArrayList<>();

        for (Message message : messages) {
            for (int sender : senders) {
                if (message.getSender() == sender) {
                    temp.add(message);
                    break;
                }
            }
        }
        return temp;
    }
    
    /**
     * Checks there are as many elements as we are requesting.
     * If not, return as many elements as there are in the list
     * @param Nmessages Number of messages requested by user
     * @return A list of messages of specified length
     */
    public List<Message> getNMessages(int Nmessages) {
        if (this.messages.size() >= (Nmessages + 1)) return this.messages.subList(0, (Nmessages + 1));
        return this.messages;
    }

    /**
     * Get all the messages sent by those senders/sender Check there are at
     * least as many elements as you are looking for If not, then just return as
     * many as you found
     *
     * @param senders People that sent the message
     * @param Nmessages Number of messages you want to retrieve
     * @return A list of messages by specified senders of specified length
     */
    public List<Message> getNMessagesBySender(int[] senders, int Nmessages) {
        List<Message> temp = getMessagesBySender(senders);
        if (temp.size() >= (Nmessages + 1)) return temp.subList(0, (Nmessages + 1));
        return temp;
    }
}
