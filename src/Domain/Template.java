/**
 * Hilo encargado de obtener las filas del excel, crear las conversaciones,
 * filtrar las conversaciones y enviarlas el Excel Reader.
 */
package Domain;

import Conversations.Conversation;
import Display.IDisplay;
import FileHandling.*;
import Filter.IFilter;
import java.io.IOException;

public class Template{

    private ExcelReader exread;
    private ExcelWriter exwrite;
    private Dictionary dict;
    private IDisplay displayMethod;
    private IFilter filter;

    public Template(ExcelReader exread, ExcelWriter exwrite, Dictionary dict, IDisplay displayMethod, IFilter filter) {
        this.exread = exread;
        this.exwrite = exwrite;
        this.dict = dict;
        this.displayMethod = displayMethod;
        this.filter = filter;
    }

    public void run() {
        while (exread.hasNext()) {
            Conversation chat = new Conversation();
            chat.setDisplayMethod(displayMethod);
            chat.transform(exread.getNext());
            if (filter.processFilter(chat)) {
                exwrite.addConversation(chat);
            }
        }
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
