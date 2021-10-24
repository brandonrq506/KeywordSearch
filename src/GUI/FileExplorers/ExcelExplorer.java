/**
 * Indica a la ventana de archivos la carpeta y el formato que debe mostrarnos.
 */
package GUI.FileExplorers;

import java.awt.FileDialog;
import javax.swing.JFrame;

public class ExcelExplorer extends FileExplorerDialog{
    
    public static String TYPE = "*.xlsx";
    public static String PATH = "C:\\Users\\Brand\\Downloads";
    
    public ExcelExplorer(JFrame mainWindow){
        super.dialogWindow = new FileDialog(dialogWindow, "Excel Selector", FileDialog.LOAD);
    }

    @Override
    public void open() {
        dialogWindow.setDirectory(PATH);
        dialogWindow.setFile(TYPE);
        dialogWindow.setMultipleMode(false);
        dialogWindow.setVisible(true);
        super.validSelection();
    }
}
