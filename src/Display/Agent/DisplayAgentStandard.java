package Display.Agent;

import Conversations.Message;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayAgentStandard implements IDisplayAgentConversation {

    private static final String REGEX = "([^) ][^)]+)(?:$|(?= [(]))";
    private List<Message> messages;
    private String cusName;
    private int[] senders;

    public DisplayAgentStandard(List<Message> messages) {
        this.messages = messages;
    }

    public DisplayAgentStandard(List<Message> messages, String cusName) {
        this.messages = messages;
        this.cusName = cusName;
    }

    @Override
    public void setSenders(int[] senders) {
        this.senders = senders;
    }

    @Override
    public void process(String text) {
        splitMessages(text);
    }

    private void splitMessages(String text) {
        try {
            Pattern checkRegex = Pattern.compile(REGEX);
            Matcher regexMatcher = checkRegex.matcher(text);

            while (regexMatcher.find()) {
                String message = regexMatcher.group();
                if (message.startsWith(cusName)) {
                    addMessage(new Message(message, 1));
                } else {
                    addMessage(new Message(message, 2));
                }
            }
        } catch (Exception e) {
            System.out.println("Error splitting messages");
        }
    }

    private void addMessage(Message message) {
        if (senders[0] == -1) {
            messages.add(message);
        }

        for (int i = 0; i < senders.length; i++) {
            if (message.getSender() == senders[i]) {
                messages.add(message);
            }
        }
    }
}
