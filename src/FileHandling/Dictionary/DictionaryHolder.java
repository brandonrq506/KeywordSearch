package FileHandling.Dictionary;

import GUI.FileExplorers.ExplorerFile;
import java.io.File;
import java.util.Iterator;
import java.util.List;

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

public class DictionaryHolder {

    private List<Dictionary> dictionaries;
    private Iterator<Dictionary> iterator;

    
    public DictionaryHolder(ExplorerFile dictionaryPack) {
        if (dictionaryPack != null) {
            initDictionaries(dictionaryPack);
            return;
        }
        initEmptyDictionary();
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Dictionary getNext() {
        return this.iterator.next();
    }

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
        this.dictionaries.add(new Dictionary(file));
    }
}
