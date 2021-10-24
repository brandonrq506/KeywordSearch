/**
 * Inicializa todos los procedimientos previos para crear un objeto Template.
 * Es buena idea tener el objeto template por separado para en un futuro
 * aplicar multi-threading
 */
package Domain;

import Display.IDisplay;
import FileHandling.*;
import Filter.IFilter;
import GUI.FileExplorers.*;
import java.io.IOException;

public class Domain {

    private ExplorerFile currentExcel;
    private ExplorerFile currentDictionary;
    
    public void setCurrentExcel(ExplorerFile currentExcelFile){
        this.currentExcel = currentExcelFile;
    }
    
    public ExplorerFile getCurrentExcel(){
        return this.currentExcel;
    }

    public ExplorerFile getCurrentDictionary() {
        return currentDictionary;
    }

    public void setCurrentDictionary(ExplorerFile currentDictionary) {
        this.currentDictionary = currentDictionary;
    }

    public void run(IDisplay dMethod, IFilter filter) throws IOException{
        Dictionary dictionary;
        if (currentDictionary == null) dictionary = new Dictionary(); 
        else dictionary = new Dictionary(currentDictionary);
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