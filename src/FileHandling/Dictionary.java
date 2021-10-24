/**
 * Posee un DicReader. Se encarga no solo de delegar la lectura de palabras
 * clave, sino tambien de proveer acceso a dichas palabras.
 */
package FileHandling;

import GUI.FileExplorers.ExplorerFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * THINGS I'M MISSING
 * 2. Implement a way to get blackKeywords
 */

public class Dictionary {
    
    private DictionaryFileReader dicReader;
    private List<String> keywords;
    private List<String> blackList;
    
    //When no directories in Domain > dictionaryFiles
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
    
    public List<String> getBlackList(){
        return null; //We still need to create a method inside dicReader
    }
    
    public void close() throws IOException{
        dicReader.close();
    }
}
