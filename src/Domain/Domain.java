/**
 * Inicializa todos los procedimientos previos para crear un objeto Template.
 * Es buena idea tener el objeto template por separado para en un futuro
 * aplicar multi-threading
 */
package Domain;

import Display.IDisplay;
import FileHandling.*;
import FileHandling.Dictionary.DictionaryHolder;
import Filter.Behavior.FilterBehavior;
import Filter.FilterManager;
import Filter.MessageSelector.MessageSelector;
import GUI.FileExplorers.*;
import java.io.IOException;

public class Domain {

    private ExplorerFile currentExcel;
    private ExplorerFile currentDictionaries;
    
    public void setCurrentExcel(ExplorerFile currentExcelFile){
        this.currentExcel = currentExcelFile;
    }
    
    public ExplorerFile getCurrentExcel(){
        return this.currentExcel;
    }

    public ExplorerFile getCurrentDictionaries() {
        return currentDictionaries;
    }

    public void setCurrentDictionary(ExplorerFile currentDictionary) {
        this.currentDictionaries = currentDictionary;
    }

    public void run(IDisplay dMethod, FilterBehavior filterBehavior, MessageSelector MS) throws IOException{
        
        DictionaryHolder dicHolder = new DictionaryHolder(currentDictionaries);
        FilterManager filManager = new FilterManager();
        filManager.setDictionaries(dicHolder.getDictionaries());
        filManager.setFilterBehavior(filterBehavior);
        filManager.setMessageSelector(MS);
        filManager.createFilterAssistant();
        
        
        new Template(
            new ExcelReader(currentExcel),
            new ExcelWriter(currentExcel),
            dMethod,
            filManager
        ).run();
    }
}