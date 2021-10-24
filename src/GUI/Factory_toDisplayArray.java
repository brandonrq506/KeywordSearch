/**
 * Returns IDisplay method with the senders to display (The array)  
 */
package GUI;

import Display.Display_AgentChat;
import Display.Display_AllChat;
import Display.Display_BotChat;
import Display.IDisplay;

public class Factory_toDisplayArray {
    
    //Customer = 1, Agent = 2, Bot = 3
    public IDisplay create(int comboBoxSelection){
        switch(comboBoxSelection){
            //0 = All
            case 0: default:
                int[] cero = {-1};
                return new Display_AllChat(cero);
            //1 = Agent & Customer
            case 1:
                int[] one = {1,2};
                return new Display_AgentChat(one);
            //2 = Bot & Customer
            case 2:
                int[] two = {1,3};
                return new Display_BotChat(two);
            //3 = Agent
            case 3:
                int[] tree = {2};
                return new Display_AgentChat(tree);
            //4 = Customer
            case 4:
                int[] four = {1};
                return new Display_AgentChat(four);
            //5 = Bot
            case 5:
                int[] five = {3};
                return new Display_BotChat(five);
        }
    }
}
