
package Display;

import Conversations.Message;
import Display.Agent.DisplayAgentStandard;
import Display.CustomerFinder.*;
import java.util.List;
import Display.Agent.IDisplayAgentConversation;

public class Display_AgentChat implements IDisplay{

    private List<Message> messages;
    private int [] senders;
    
    private DisplayChat_Controller controller;
    private IDisplayAgentConversation aChat;
    private Finder_CustomerName cChat;
    
    public Display_AgentChat(int [] senders){
        this.senders = senders;
    }
    
    @Override
    public void process(String text) {
        //Encontramos los puntos clave de la conversation, y si esta posee chat con bot/agent o no.
        controller = new DisplayChat_Controller(text);
        //Encontramos el nombre del cliente
        cChat = new Finder_Factory().create(controller.chatInstance);
        cChat.find(text);
        //En este caso solo nos interesa la conversation del agente, por lo que
        //creamos la instancia, enviamos los mensajes a mostrar, y procesamos.
        if(controller.agentFound){
            aChat = new DisplayAgentStandard(messages, cChat.getCustomerName());
            aChat.setSenders(senders);
            aChat.process(text.substring(controller.beginAgent));
        }
        //QUE OCURRE SI NO HAY CONVERSATION DE ESTE TIPO? 
        //Supongo que filter es lo primero que debe revisar, si messages = null empty
    }

    @Override
    public void setArray(List<Message> messages) {
        this.messages = messages;
    }
}