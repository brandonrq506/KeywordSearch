
package Display.Bot;

import Conversations.Message;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Display_SDCBot implements IDisplay_BotChat{
    
    private static final String REGEX = "([^) ][^)]+)(?:$|(?= [(]))";
    List<Message> messages;
    String cusName;
    int[] senders;

    @Override
    public void setArray(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void setConfig(List<Message> messages, String cusName, int[] senders) {
        this.messages = messages;
        this.cusName = cusName;
        this.senders = senders;
    }

    @Override
    public void process(String text) {
        splitMessages(text);
    }
    
    private void splitMessages(String text){
        Pattern checkRegex = Pattern.compile(REGEX);
        Matcher regexMatcher = checkRegex.matcher(text);

        while (regexMatcher.find()) {
            String message = regexMatcher.group();
            if(message.startsWith(cusName)) addMessage(new Message(message, 1)); //Customer = 1, Bot = 3
            else                            addMessage(new Message(message, 3));
        }
    }
    
    private void addMessage(Message message){
        if(senders[0] == -1) messages.add(message);
        
        for (int i = 0; i < senders.length; i++) {
            if(message.getSender() == senders[i]) messages.add(message);
        }
    }
}
