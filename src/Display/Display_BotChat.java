
package Display;

import Conversations.Message;
import Display.Bot.DisplayBot_Factory;
import Display.Bot.IDisplay_BotChat;
import Display.CustomerFinder.Finder_CustomerName;
import Display.CustomerFinder.Finder_Factory;
import java.util.List;

public class Display_BotChat implements IDisplay{
    
    private List<Message> messages;
    private int [] senders;
    
    private DisplayChat_Controller controller;
    private IDisplay_BotChat bChat;
    private Finder_CustomerName cChat;
    
    public Display_BotChat(int [] senders){
        this.senders = senders;
    }

    @Override
    public void process(String text) {
        //Encontramos los puntos clave de la conversation, y si esta posee chat con bot/agent o no.
        controller = new DisplayChat_Controller(text);
        //Encontramos el nombre del cliente
        cChat = new Finder_Factory().create(controller.chatInstance);
        cChat.find(text);
        //Si la conversation posee conversation con bot
        if(controller.botFound){
            bChat = new DisplayBot_Factory().create(controller.chatInstance);
            bChat.setConfig(messages, cChat.getCustomerName(), senders);
            if(controller.endBot != -1) bChat.process(text.substring(controller.beginBot, controller.endBot));
            else                        bChat.process(text.substring(controller.beginBot));
        }
    }

    @Override
    public void setArray(List<Message> messages) {
        this.messages = messages;
    }
}
