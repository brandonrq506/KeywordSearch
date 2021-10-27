package Filter.FilterBehavior;

import Conversations.Message;
import Filter.FilterAssistant;

public class MessageLevelFilter{

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
