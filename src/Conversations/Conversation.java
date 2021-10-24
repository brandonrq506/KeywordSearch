
package Conversations;

import Display.IDisplay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Conversation {
    
    private IDisplay displayMethod;
    
    private List<Message> messages;
    private List<String> additionalColums;
    
    private String transcriptId;
    private String disposition;
    private String customer;
    //String email;
    //String phoneNumber;
    
    public Conversation(){
        messages = new ArrayList<>();
        additionalColums = new ArrayList();
    }
    
    public void transform(List<String> columns){
        transcriptId = columns.get(0);
        try {
            handleDisplay(columns.get(1).toLowerCase());
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Issue on: " + transcriptId);
        }
        disposition = columns.get(2);
        if(columns.size() > 3) fillAdditionalColumns(columns);
    }
    
    private void handleDisplay(String cellText){
        String chat = cellText.replaceAll(":\\)", "");
        this.displayMethod.setArray(messages);
        this.displayMethod.process(chat);
    }
    
    private void fillAdditionalColumns(List<String> columns){
        Iterator<String> iterator = columns.listIterator(3);
        while(iterator.hasNext()){
            additionalColums.add(iterator.next());
        }
    }
    
    public List<Message> getMessages(int [] senders){
        List<Message> temp = new ArrayList<>();
        for(Message message: messages){
            for(int sender: senders){
                if(message.getSender() == sender){
                    temp.add(message);
                    break;
                }
            }
        }
        return temp;
    }
    
    public List<Message> getAllMessages(){
        return this.messages;
    }

    public int getMessagesCount(){
        return this.messages.size();
    }
    
    public void addMessages(List<Message> messages){
        this.messages.addAll(messages);
    }
    
    public String getDisposition(){
        return this.disposition;
    }

    public String getTranscriptId() {
        return transcriptId;
    }

    public String getCustomer() {
        return customer;
    }

    public String getEmail() {
        //return email;
        return null;
    }

    public String getPhoneNumber() {
        //return phoneNumber;
        return null;
    }
    
    public void setDisplayMethod(IDisplay displayMethod){
        this.displayMethod = displayMethod;
    }
    
    public List<String> getAdditionalColumns(){
        return this.additionalColums;
    }
}