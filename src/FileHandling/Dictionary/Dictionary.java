/**
 * Responsabilidades:
 * 1. Generar un dictioanryReader encargado de leer las palabras clave.
 * 2. Almacenar las palabras clave.
 * 3. Almacenar el nombre del archivo del cual se obtuvieron las palabras clave.
 */
package FileHandling.Dictionary;

import GUI.FileExplorers.ExplorerFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    
    private DictionaryFileReader dicReader;
    private List<String> keywords;
    private String textFileName;
    
    
    //Cuando no se especifica leer un txt file, se utilizara esto por defecto.
    public Dictionary(){
        this.keywords = new ArrayList<>();
        this.keywords.add(" ");
    }
    
    //When there are directories in Domain > dictionaryFiles
    public Dictionary(ExplorerFile fiEx) throws IOException{
        dicReader = new DictionaryFileReader(fiEx);
        this.keywords = dicReader.getKeywords();
        System.out.println(keywords);
        dicReader.close();
    }
    
    public List<String> getKeywords(){
        return this.keywords;
    }
    
    public String getTextFileName(){
        return this.textFileName;
    }
    
    public void close() throws IOException{
        dicReader.close();
    }
}
