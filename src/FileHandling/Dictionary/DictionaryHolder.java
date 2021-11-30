/**
 * Responsabilities:
 * 1. Inicializar todos los diccionarios. 
 *    a. Provee a los diccionarios el file que deben leer
 *    b. En caso de no tener file, inicia un diccionario vacios
 * 
 * 2. Almacenar todos los objetos diccionario
 * 4. Poseer un iterador para facilitar la comunicacion entre clases
 * 5. Proveer diccionarios a otras clases.
 */

package FileHandling.Dictionary;

import GUI.FileExplorers.ExplorerFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DictionaryHolder {

    private List<Dictionary> dictionaries;
    private Iterator<Dictionary> iterator;
    
    
    //Debemos verificar que en caso de ser NULL, realmente no retorne una excepcion
    public DictionaryHolder(ExplorerFile dictionaryPack) {
        this.dictionaries = new ArrayList<>();
        if (dictionaryPack != null) {
            initDictionaries(dictionaryPack);
            return;
        }
        initEmptyDictionary();
    }
    
    public List<Dictionary> getDictionaries(){
        return this.dictionaries;
    }
    
//Commented until we have a better solution to the need to iterate through 
//all the dictionaries multiple times
//    public boolean hasNext() {
//        return this.iterator.hasNext();
//    }
//    
//    public Dictionary getNext() {
//        return this.iterator.next();
//    }

    private void initEmptyDictionary() {
        this.dictionaries.add(new Dictionary());
        this.iterator = this.dictionaries.iterator();
    }

    private void initDictionaries(ExplorerFile dictionaryPack) {
        while (dictionaryPack.hasNext()) {
            initFullDictionary(dictionaryPack.getNext());
        }
        this.iterator = this.dictionaries.iterator();
    }

    private void initFullDictionary(File file) {
        try {
            this.dictionaries.add(new Dictionary(file));
            System.out.println("Dictionary Added");
        } catch (IOException e) {
        }
    }
}
