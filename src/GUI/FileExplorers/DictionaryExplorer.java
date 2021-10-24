/**
 * Indica a la ventana de archivos la carpeta y el formato que debe mostrarnos.
 */
package GUI.FileExplorers;

import java.awt.FileDialog;
import javax.swing.JFrame;

public class DictionaryExplorer extends FileExplorerDialog{
    
    public static String TYPE = "*.txt";
    public static String PATH = "C:\\Users\\Brand\\Downloads";
    
    public DictionaryExplorer(JFrame mainWindow){
        super.dialogWindow = new FileDialog(dialogWindow, "Report Browser", FileDialog.LOAD);
    }

    @Override
    public void open() {
        dialogWindow.setDirectory(PATH);
        dialogWindow.setFile(TYPE);
        dialogWindow.setVisible(true);
        super.validSelection();
    }
}
