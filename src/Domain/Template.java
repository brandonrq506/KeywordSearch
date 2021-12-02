package Domain;

import Conversations.Conversation;
import Display.IDisplay;
import FileHandling.*;
import Filter.FilterManager;
import java.io.IOException;

public class Template {

    private final ExcelReader exread;
    private final ExcelWriter exwrite;
    private final ExcelWriterNoMatch exwriteNoMatch;
    private final IDisplay displayMethod;
    private final FilterManager filterManager;

    public Template(ExcelReader exread, ExcelWriter exwrite, ExcelWriterNoMatch exwriteNoMatch, IDisplay displayMethod, FilterManager filterManager) {
        this.exread = exread;
        this.exwrite = exwrite;
        this.exwriteNoMatch = exwriteNoMatch;
        this.displayMethod = displayMethod;
        this.filterManager = filterManager;
    }

    public void run() {
        while (exread.hasNext()) {
            Conversation chat = new Conversation();
            chat.setDisplayMethod(displayMethod);
            chat.transform(exread.getNext());
            if(chat.getMessagesCount() > 0) {
                filterManager.Filter(chat);
            } else{
                //Es peligroso simplemente ignorar todo chat que no tenga mensajes en base al programa
                //ya que pueden ser los mayor indicios que tenemos de bugs.
                //Mejor imprimir algo en consola en caso de que esto ocurra y siempre revisarlos manualmente
                //En caso de realmente haber un chat con 0 mensajes, deberíamos capturar ese detalle antes en
                //la logica del programa. Pero de momento: 
                System.out.println("Found chat with no messages. Make sure is not a bug: " + chat.getTranscriptId());
            }
        }

        try {
            exread.close();
        } catch (IOException ex) {
            System.out.println("Error closing Excel Reader File");
        }

        exwrite.addConverastions(filterManager.getMatchList());
        exwriteNoMatch.addConverastions(filterManager.getNoMatchList());
        try {
            exwrite.open();
            exwrite.write();
            exwriteNoMatch.open();
            exwriteNoMatch.write();
        } catch (IOException ex) {
            System.out.println("Error closing excel document");
        } finally {
            exwrite.close();
            exwriteNoMatch.close();
        }
    }
}
