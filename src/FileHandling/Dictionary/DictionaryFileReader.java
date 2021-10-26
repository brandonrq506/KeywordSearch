/**
 * Responsabilidades:
 * 1. Leer el archivo .txt especificado.
 */
package FileHandling.Dictionary;

import FileHandling.IFileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DictionaryFileReader implements IFileHandler{

    private final File textFile;
    private Scanner sc;
    
    
    public DictionaryFileReader(File textFile) throws IOException {
        this.textFile = textFile;
        open();
    }

    @Override
    public final void open() throws FileNotFoundException {
        sc = new Scanner(this.textFile);
    }
    
    public List<String> getKeywords(){
        return Arrays.asList(sc.nextLine().split("\\n"));
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }
}
