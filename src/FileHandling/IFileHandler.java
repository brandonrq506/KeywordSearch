/**
 * Define las funciones basicas de todas las clases que deseen manejar archivos
 */
package FileHandling;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileHandler {
    
    void open()throws FileNotFoundException;
    
    void close() throws IOException;
}
