/**
 * Ventana principal del programa. 
 */
package GUI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class frmMainFrame extends javax.swing.JFrame {

    public frmMainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainBackground = new javax.swing.JPanel();
        lblDisplay = new javax.swing.JLabel();
        cbDisplay = new javax.swing.JComboBox<>();
        lblApplyKeywords = new javax.swing.JLabel();
        cbFilterLevel = new javax.swing.JComboBox<>();
        lblFilter = new javax.swing.JLabel();
        cbFilter = new javax.swing.JComboBox<>();
        btnRun = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnDictionary = new javax.swing.JButton();
        tn_NumberMessages = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Brandon Keyword Search Tool");

        lblDisplay.setText("Display");

        cbDisplay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Agent Customer", "Bot Customer", "Agent", "Customer", "Bot" }));

        lblApplyKeywords.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApplyKeywords.setText("Apply Keywords:");

        cbFilterLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Message Level", "Conversation Level" }));

        lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFilter.setText("Apply Filters to:");

        cbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRun.setText("Run");

        btnExcel.setText("Excel");

        btnDictionary.setText("Dictionary");

        tn_NumberMessages.setText("-1");

        javax.swing.GroupLayout pnlMainBackgroundLayout = new javax.swing.GroupLayout(pnlMainBackground);
        pnlMainBackground.setLayout(pnlMainBackgroundLayout);
        pnlMainBackgroundLayout.setHorizontalGroup(
            pnlMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainBackgroundLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDictionary)
                    .addComponent(btnExcel)
                    .addComponent(cbFilterLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApplyKeywords)
                    .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilter)
                    .addComponent(cbDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisplay))
                .addGap(27, 27, 27)
                .addComponent(tn_NumberMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(645, Short.MAX_VALUE))
        );
        pnlMainBackgroundLayout.setVerticalGroup(
            pnlMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainBackgroundLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblApplyKeywords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFilterLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn_NumberMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnExcel)
                .addGap(38, 38, 38)
                .addComponent(btnDictionary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnRun)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDictionary;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnRun;
    private javax.swing.JComboBox<String> cbDisplay;
    private javax.swing.JComboBox<String> cbFilter;
    private javax.swing.JComboBox<String> cbFilterLevel;
    private javax.swing.JLabel lblApplyKeywords;
    private javax.swing.JLabel lblDisplay;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JPanel pnlMainBackground;
    private javax.swing.JTextField tn_NumberMessages;
    // End of variables declaration//GEN-END:variables

    public JButton btnExcel(){
        return this.btnExcel;
    }
    
    public JButton btnDictionary(){
        return this.btnDictionary;
    }
    
    public JButton btnRun(){
        return this.btnRun;
    }
    
    public JComboBox cbDisplay(){
        return this.cbDisplay;
    }
    
    public JComboBox cbFilter(){
        return this.cbFilter;
    }
    
    public JComboBox cbFilterLevel(){
        return this.cbFilterLevel;
    }
    
    public JTextField tfNumberMessages(){
        return this.tn_NumberMessages;
    }
}
