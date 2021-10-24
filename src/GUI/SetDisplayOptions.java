/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

public class SetDisplayOptions {

    public String[] getString(int cbIndex) {
        switch (cbIndex) {
            case 0:
                return new String[]{"All", "Agent Customer", "Bot Customer", "Agent", "Customer", "Bot"};
            case 1:
                return new String[]{"All", "Agent", "Customer"};
            case 2:
                return new String[]{"All", "Bot", "Customer"};
            default:
                return new String[]{"All"};
        }
    }
}
