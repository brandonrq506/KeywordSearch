/**
 * Responsabilidades:
 * 1. Leer el archivo .txt especificado.
 */
package FileHandling.Dictionary;

import FileHandling.IFileHandler;
import GUI.FileExplorers.ExplorerFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DictionaryFileReader implements IFileHandler{

    private File archivo;
    private ExplorerFile fiEx;
    private Scanner sc;
    
    
    public DictionaryFileReader(ExplorerFile fiEx) throws IOException {
        this.fiEx = fiEx;
        open();
    }

    @Override
    public final void open() throws FileNotFoundException {
        archivo = new File(fiEx.getFiles());
        sc = new Scanner(archivo);
    }
    
    public List<String> getKeywords(){
        return Arrays.asList(sc.nextLine().split(","));
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }
}
