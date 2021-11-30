
package GUI.FileExplorers;

import java.io.File;

public class ExplorerFile{
    
    private final File[] files;
    private int currentFileIndex;
    
    
    //Is initialized in FileExplorerDialog
    public ExplorerFile(File[] files){
        this.files = files;
        printFiles();
    }
    
    public File[] getAllFiles(){
        return this.files;
    }
    
    public boolean hasNext(){
        return files.length > currentFileIndex;
    }
    
    public File getNext(){
           return files[this.currentFileIndex++];
    }

    private void printFiles(){
        System.out.println("Files Loaded --------------------");
        for (File file: files){
            System.out.println("File: " + file.getAbsolutePath());
        }
    }
}