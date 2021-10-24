/**
 * Nuestra version de la clse 'File'
 * Nos ayuda a pasar el directorio y nombre del file a distintas clases de excel
 */
package GUI.FileExplorers;

public class ExplorerFile {
    
    private String directory;
    private String name;
    
    public ExplorerFile(String directory, String name){
        this.directory = directory;
        this.name = name;
        System.out.println("Name: " + name);
        System.out.println("directory: " + directory);
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDirectory(){
        return this.directory;
    }

}
