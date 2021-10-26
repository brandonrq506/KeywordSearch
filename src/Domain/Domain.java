/**
 * Inicializa todos los procedimientos previos para crear un objeto Template.
 * Es buena idea tener el objeto template por separado para en un futuro
 * aplicar multi-threading
 */
package Domain;

import FileHandling.Dictionary.Dictionary;
import Display.IDisplay;
import FileHandling.*;
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
        
        /*Maybe this dictionary logic should be included within the dictionary
        object, and not in the run method in the Domain class*/
        Dictionary dictionary;
        if (currentDictionaries == null) dictionary = new Dictionary(); 
        else dictionary = new Dictionary(currentDictionaries);
        filter.setKeywords(dictionary.getKeywords());
        
        new Template(
            new ExcelReader(currentExcel),
            new ExcelWriter(currentExcel),
            dictionary,
            dMethod,
            filter
        ).run();
    }
}