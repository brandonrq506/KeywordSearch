/**
 * Is our file container,
 */
package GUI.FileExplorers;

import java.io.File;

public class ExplorerFile {
    
    private File[] files;
    
    public ExplorerFile(File[] files){
        this.files = files;
        printFiles();
    }
    
    public File[] getFiles(){
        return this.files;
    }
    
    private void printFiles(){
        for (File file: files){
            System.out.println("File: " + file.getAbsolutePath());
        }
    }
}
