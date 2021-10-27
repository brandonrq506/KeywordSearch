
package Filter.FilterBehavior;

import Conversations.Message;
import Filter.FilterAssistant;
import java.util.List;

/**
 * Ejemplo de uso: Principalmente con keywords compuestas.
 * Keywords = {website, retainer, order - confirmation - website}
 * 
 * Se iterará por la palabra clave 'order' hasta encontrarla en la conversación
 * el mensaje se macarcará como keyword passed y se moverá a la palabra clave
 * 'confirmation', se esta no encontrarse en toda la conversación, se rompera el
 * ciclo de iteraciones y se devolverá false, si es encontrada, continua con
 * 'website'.
 */

public class ConversationLevelFilter{

    @Override
    public boolean filter() {
        boolean found = false;
        //Este for-loop nos garantiza que por cada filtro se revisaran TODOS los mensajes.
        for(String k: keywords){
            if(k.contains("-")) found = groupKeyFinder(messages, k.split("-"));
            else                found = individualKeyFinder(messages, k);
        }
        return found;
    }

    private boolean individualKeyFinder(List<Message> messages, String key){
        for(Message m: messages){
            if(m.getText().contains(key)){
                m.setPassedFilter();
                return true;
            }
        }
        return false;
    }
    
    private boolean groupKeyFinder(List<Message> messa, String[] key){
        boolean found = false;
        //Este loop asegura que cada keyword iterara por todos los mensajes
        for(String keyword: key){
            found = false;
            for(Message message: messa){
                if(message.getText().contains(keyword)){
                    found = true;
                    //All the messages returning true will be set as filterPassed
                    message.setPassedFilter();
                    //Once the word is found in a message, we break the loop, so it doesn't
                    //check following messages at the risk of returning false
                    break;
                }
            }
            //Una vez iterados todos los mensajes, si la palabra clave fue encontrada
            //en alguno de ellos, el loop continua con el resto de palabras. Si no,
            //el loop se corta y se retorna el false.
            if(!found) break;
        }
        return found;
    }
}
