

package Domain;

import Conversations.Conversation;
import Display.IDisplay;
import FileHandling.*;
import Filter.FilterManager;
import java.io.IOException;

public class Template{

    private ExcelReader exread;
    private ExcelWriter exwrite;
    private IDisplay displayMethod;
    private FilterManager filterManager;

    public Template(ExcelReader exread, ExcelWriter exwrite, IDisplay displayMethod, FilterManager filterManager) {
        this.exread = exread;
        this.exwrite = exwrite;
        this.displayMethod = displayMethod;
        this.filterManager = filterManager;
    }

    public void run() {
        while (exread.hasNext()) {
            Conversation chat = new Conversation();
            chat.setDisplayMethod(displayMethod);
            chat.transform(exread.getNext());
            filterManager.Filter(chat);
        }
        
        try {
            exread.close();
        } catch (IOException ex) {
            System.out.println("Error closing Excel Reader File");
        }
        
        exwrite.addConverastions(filterManager.getMatchList());
        try {
            exwrite.open();
            exwrite.write();
        } catch (IOException ex) {
            System.out.println("Error closing excel document");
        } finally {
            exwrite.close();
        }
    }
}
