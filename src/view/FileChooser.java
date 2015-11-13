package view;

/**
 *
 * @author Diego
 */
public final class FileChooser extends javax.swing.JFrame {
    /**
     * Creates new form FileChooser
     * @param controller
     * @param Type
     * @param component
     */
    public FileChooser(control.MainViewControl controller, String Type, String component){
        this.myController = controller;
        lookAndFeel();
        initComponents();
        if (Type.equals(FOLDER)){
            FileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        }else if (Type.equals(FILE)){
            FileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        }
        this.setTitle(APP_NAME);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.component = component;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        FileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        javax.swing.JFileChooser fileChoosed = (javax.swing.JFileChooser)evt.getSource();
        String command = evt.getActionCommand();
        if(command.equals(javax.swing.JFileChooser.APPROVE_SELECTION)){
            myController.updateRoute(component,fileChoosed.getSelectedFile().getPath());
            dispose();
        }else if(command.equals(javax.swing.JFileChooser.CANCEL_SELECTION)){
            dispose();
        }
    }//GEN-LAST:event_FileChooserActionPerformed

    public void lookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private final control.MainViewControl myController;
    private final String APP_NAME = "Administrador de FRDNE";
    private final String FOLDER = "folder";
    private final String FILE = "file";
    private final String component;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    // End of variables declaration//GEN-END:variables
}
