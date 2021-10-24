
package GUI;

public class Factory_Filter {
    
    public int [] create(String selection){
        if(selection.contains("All")){
            int[] senders = {-1};
            return senders;
        }
        
        int position = 0;
        //Creo que todo este proceso se puede facilitar con ENUMS
        String[] sendersText = selection.split(" ");
        //Obtiene un int[] justo del tamano requerido
        int[] senders = new int[sendersText.length];
        
        if(selection.contains("Customer")){
            senders[position++] = 1;
        }
        if(selection.contains("Agent")){
            senders[position++] = 2;
        }
        if(selection.contains("Bot")){
            senders[position++] = 3;
        }
        return senders;
    }
}
