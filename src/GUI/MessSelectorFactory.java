
package GUI;

import Filter.MessageSelector.*;

public class MessSelectorFactory {
    
    private int[] sender;
    private int nMessages;
    
    public MessSelectorFactory(int[] sender, int nMessages){
        this.sender = sender;
        this.nMessages = nMessages;
    }
    
    public MessageSelector getMS(){
        if (this.sender[0] == -1 && this.nMessages == -1)
            return new AllMessages();
        else if (this.sender[0] != -1 && this.nMessages != -1)
            return new NBySender(sender, nMessages);
        else if (this.sender[0] != -1 && this.nMessages == -1)
            return new MessagesBySender(sender);
        else
            return new ByNMessages(nMessages);
    }
}
