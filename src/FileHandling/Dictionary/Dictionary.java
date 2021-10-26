/**
 * Responsabilidades:
 * 1. Generar un dictioanryReader encargado de leer las palabras clave.
 * 2. Almacenar las palabras clave.
 * 3. Almacenar el nombre del archivo del cual se obtuvieron las palabras clave.
 */
package FileHandling.Dictionary;

import java.io.File;
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
        this.textFileName = "Default";
    }
    
    //Cuando al menos un .txt fue selecionado
    public Dictionary(File dictionaryFile) throws IOException{
        this.dicReader = new DictionaryFileReader(dictionaryFile);
        setKeywords();
        setDictionaryName(dictionaryFile);
        closeDictionaryReader();
    }
    
    public List<String> getKeywords(){
        return this.keywords;
    }
    
    public String getTextFileName(){
        return this.textFileName;
    }
    
    private void setKeywords(){
        this.keywords = dicReader.getKeywords();
    }
    
    private void setDictionaryName(File dictionaryFile){
        this.textFileName = dictionaryFile.getName();
    }
    
    private void closeDictionaryReader() throws IOException{
        this.dicReader.close();
    }

    @Override
    public String toString() {
        
        System.out.println("Dictionary Name: " + this.textFileName);
        for(String keyword: keywords){
            System.out.println(keyword);
        }
        
        return "";
    }
    
    
}
