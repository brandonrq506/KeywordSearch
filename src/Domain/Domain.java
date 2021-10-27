/**
 * Inicializa todos los procedimientos previos para crear un objeto Template.
 * Es buena idea tener el objeto template por separado para en un futuro
 * aplicar multi-threading
 */
package Domain;

import Display.IDisplay;
import FileHandling.*;
import FileHandling.Dictionary.DictionaryHolder;
import Filter.IFilter;
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

    public void run(IDisplay dMethod, IFilter filter) throws IOException{
        
        DictionaryHolder dicHolder = new DictionaryHolder(currentDictionaries);
        filter.setKeywords(dicHolder);
        
        new Template(
            new ExcelReader(currentExcel),
            new ExcelWriter(currentExcel),
            dMethod,
            filter
        ).run();
    }
}