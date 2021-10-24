/*
 * Ventana que permite acceder a los archivos del SO
 */
package GUI.FileExplorers;

import java.awt.FileDialog;

public abstract class FileExplorerDialog {
    
    protected FileDialog dialogWindow;
    protected String directory;
    
    protected ExplorerFile file;

    public abstract void open();
    
    protected void validSelection(){
        if(dialogWindow.getFile() != null)
            file = new ExplorerFile(dialogWindow.getDirectory(), dialogWindow.getFile());
    }
    
    public boolean fileSelected(){
        return file != null;
    }
    
    public ExplorerFile getFile(){
        return this.file;
    }
    
    public void deleteFile(){
        this.file = null;
    }
}
