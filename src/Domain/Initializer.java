/*
 * Inicializa el frame principal para el usuario
 */
package Domain;

import GUI.Controller;
import GUI.frmMainFrame;

public class Initializer {
    
    public static void main(String[] args) {

        frmMainFrame frame = new frmMainFrame();
        Domain domain = new Domain();
        
        Controller controller = new Controller(frame, domain);
    }
}
