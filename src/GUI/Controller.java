/*
 * Controla la comunicacion entre el Frame principal y la clase Domain
 * Es en esta ultima donde se lleva a cabo el proceso de correr los hilos
 */
package GUI;

import Display.IDisplay;
import Domain.Domain;
import Filter.ConversationLevelFilter;
import Filter.IFilter;
import Filter.MessageLevelFilter;
import GUI.FileExplorers.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {

    private frmMainFrame frame;
    private Domain domain;

    public Controller(frmMainFrame frame, Domain domain) {
        this.frame = frame;
        this.domain = domain;
        setConfig();
    }

    private void setConfig() {
        this.frame.btnExcel().addActionListener(btnExcel);
        this.frame.btnDictionary().addActionListener(btnDictionary);
        this.frame.btnRun().addActionListener(btnRun);
        this.frame.cbDisplay().addActionListener(cbDisplay);
        this.frame.cbDisplay().setSelectedIndex(1);
        this.frame.btnRun().setEnabled(false);
        this.frame.setVisible(true);
    }
    
    ActionListener cbDisplay = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.cbFilter().setModel(new javax.swing.DefaultComboBoxModel<>(
                new SetDisplayOptions().getString(frame.cbDisplay().getSelectedIndex())
            ));
        }
    };

    ActionListener btnExcel = new ActionListener() {
        FileExplorerDialog explorer = new ExcelExplorer(frame);

        @Override
        public void actionPerformed(ActionEvent e) {
            explorer.deleteFile();
            explorer.open();
            if (explorer.fileSelected()) {
                domain.setCurrentExcel(explorer.getFile());
                frame.btnRun().setEnabled(true);
            }
        }
    };

    ActionListener btnDictionary = new ActionListener() {
        FileExplorerDialog explorer = new DictionaryExplorer(frame);

        @Override
        public void actionPerformed(ActionEvent e) {
            explorer.deleteFile();
            explorer.open();
            if (explorer.fileSelected()) {
                domain.setCurrentDictionary(explorer.getFile());
            }
        }
    };

    ActionListener btnRun = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                domain.run(getDisplayOption(), getFilter());
            } catch (IOException ex) {
                System.out.println(ex.fillInStackTrace());
            }
        }
    };

    private IDisplay getDisplayOption() {
        int selection = this.frame.cbDisplay().getSelectedIndex();
        return new Factory_toDisplayArray().create(selection);
    }

    private IFilter getFilter() {
        IFilter filterBehavior;
        if (frame.cbFilterLevel().getSelectedIndex() == 0) {
            filterBehavior = new MessageLevelFilter();
        } else {
            filterBehavior = new ConversationLevelFilter();
        }

        filterBehavior.setSenders(
            new Factory_Filter().create(frame.cbFilter().getSelectedItem().toString())
        );

        return filterBehavior;
    }
}
