
package Filter;

import Conversations.Message;

/**
 * Ejemplo de uso:
 * Keywords = {website, retainer, order - confirmation - website}
 * 
 * Si algun mensaje de la conversation contiene las palabras 'website' o 'retainer'
 * esto será considerado como que el mensaje cumple con los criterios de filtro
 * Si un solo mensaje contiene {website, confirmation y order} ese mensaje
 * cumple con los criterios del filtro.
 */

public class MessageLevelFilter extends Filter{

    @Override
    public boolean filter() {
        boolean found = false;
        for(Message m: messages){
            for(String k: keywords){
                if(k.contains("-")) found = groupKeyFinder(m, k.split("-"));
                else                found = individualKeyFinder(m, k);
                
                if(found) break;
            }
            if(found){
                m.setPassedFilter();
                break;
            }
        }
        return found;
    }

    private boolean groupKeyFinder(Message messa, String[] key){
        for(String keyword: key){
            if(!messa.getText().contains(keyword)) return false;
        }
        return true;
    }
    
    private boolean individualKeyFinder(Message messa, String key){
        return messa.getText().contains(key);
    }
}
