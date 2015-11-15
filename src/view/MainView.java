package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public final class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     * @param controller
     */
    public MainView(control.MainViewControl controller) {
        this.myController = controller;
        lookAndFeel();
        initComponents();
        this.setTitle(APP_NAME);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        DestinyFoldersCheck = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FRDNEAddressText = new javax.swing.JTextField();
        DestinyAddressText = new javax.swing.JTextField();
        ComparatorAddressText = new javax.swing.JTextField();
        FRDNEAddressButton = new javax.swing.JButton();
        DestinyAddressButton = new javax.swing.JButton();
        ComparatorAddressButton = new javax.swing.JButton();
        GlobalStateLabel = new javax.swing.JLabel();
        ReportButton = new javax.swing.JButton();
        RestartButton = new javax.swing.JButton();
        CityCheck = new javax.swing.JCheckBox();
        CompareFRDNECheck = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido al programa de Administración de FRDNE ¿Qué desea hacer?");

        DestinyFoldersCheck.setText("Separar archivos en carpetas según su centro");
        DestinyFoldersCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinyFoldersCheckActionPerformed(evt);
            }
        });

        jLabel2.setText("Dirección FRDNE");

        jLabel3.setText("Dirección destino");

        jLabel4.setText("Archivo Comparador");

        FRDNEAddressText.setEditable(false);
        FRDNEAddressText.setAutoscrolls(false);

        DestinyAddressText.setEditable(false);
        DestinyAddressText.setAutoscrolls(false);

        ComparatorAddressText.setEditable(false);
        ComparatorAddressText.setAutoscrolls(false);

        FRDNEAddressButton.setText("...");
        FRDNEAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FRDNEAddressButtonActionPerformed(evt);
            }
        });

        DestinyAddressButton.setText("...");
        DestinyAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinyAddressButtonActionPerformed(evt);
            }
        });

        ComparatorAddressButton.setText("...");
        ComparatorAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComparatorAddressButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DestinyAddressText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(ComparatorAddressText)
                    .addComponent(FRDNEAddressText, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DestinyAddressButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(FRDNEAddressButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComparatorAddressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FRDNEAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FRDNEAddressButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DestinyAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinyAddressButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComparatorAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComparatorAddressButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GlobalStateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        GlobalStateLabel.setForeground(new java.awt.Color(255, 0, 0));
        GlobalStateLabel.setText("LABEL DE ESTADO ---------------");

        ReportButton.setText("Iniciar Proceso");
        ReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportButtonActionPerformed(evt);
            }
        });

        RestartButton.setText("Reiniciar");
        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });

        CityCheck.setText("Separar archivos según críterio Ciudad");
        CityCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityCheckActionPerformed(evt);
            }
        });

        CompareFRDNECheck.setText("Comparar con Archivo");
        CompareFRDNECheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompareFRDNECheckActionPerformed(evt);
            }
        });

        jButton1.setText("Generar Informe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CompareFRDNECheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CityCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DestinyFoldersCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GlobalStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RestartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(DestinyFoldersCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CityCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CompareFRDNECheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GlobalStateLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RestartButton)
                    .addComponent(jButton1)
                    .addComponent(ReportButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void DestinyFoldersCheckActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        myController.checkConditions();
    }                                                   

    private void CompareFRDNECheckActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        myController.checkConditions();
    }                                                 

    private void FRDNEAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        myController.getARoute(FOLDER,FRDNE);
    }                                                  

    private void DestinyAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        myController.getARoute(FOLDER,DESTINY);
    }                                                    

    private void ComparatorAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        myController.getARoute(FILE, TXT);
    }                                                       

    private void ReportButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        myController.startProccess();
    }                                            

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        myController.setInitialConditions();
    }                                             

    private void CityCheckActionPerformed(java.awt.event.ActionEvent evt) {                                          
        myController.checkConditions();
    }                                         

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        myController.getReport();
    }                                        

    public JTextField getComparatorAddressText() {
        return ComparatorAddressText;
    }

    public void setComparatorAddressText(JTextField ComparatorAddressText) {
        this.ComparatorAddressText = ComparatorAddressText;
    }

    public JTextField getDestinyAddressText() {
        return DestinyAddressText;
    }

    public void setDestinyAddressText(JTextField DestinyAddressText) {
        this.DestinyAddressText = DestinyAddressText;
    }

    public JCheckBox getDestinyFoldersCheck() {
        return DestinyFoldersCheck;
    }

    public void setDestinyFoldersCheck(JCheckBox DestinyFoldersCheck) {
        this.DestinyFoldersCheck = DestinyFoldersCheck;
    }

    public JTextField getFRDNEAddressText() {
        return FRDNEAddressText;
    }

    public void setFRDNEAddressText(JTextField FRDNEAddressText) {
        this.FRDNEAddressText = FRDNEAddressText;
    }

    public JCheckBox getCompareFRDNECheck() {
        return CompareFRDNECheck;
    }

    public void setCompareFRDNECheck(JCheckBox CompareFRDNECheck) {
        this.CompareFRDNECheck = CompareFRDNECheck;
    }

    public JButton getComparatorAddressButton() {
        return ComparatorAddressButton;
    }

    public void setComparatorAddressButton(JButton ComparatorAddressButton) {
        this.ComparatorAddressButton = ComparatorAddressButton;
    }

    public JButton getDestinyAddressButton() {
        return DestinyAddressButton;
    }

    public void setDestinyAddressButton(JButton DestinyAddressButton) {
        this.DestinyAddressButton = DestinyAddressButton;
    }

    public JButton getFRDNEAddressButton() {
        return FRDNEAddressButton;
    }

    public void setFRDNEAddressButton(JButton FRDNEAddressButton) {
        this.FRDNEAddressButton = FRDNEAddressButton;
    }

    public JLabel getGlobalStateLabel() {
        return GlobalStateLabel;
    }

    public void setGlobalStateLabel(JLabel GlobalStateLabel) {
        this.GlobalStateLabel = GlobalStateLabel;
    }

    public JButton getStartProccessButton() {
        return ReportButton;
    }

    public void setStartProccessButton(JButton StartProccessButton) {
        this.ReportButton = StartProccessButton;
    }

    public JCheckBox getCityCheck() {
        return CityCheck;
    }

    public void setCityCheck(JCheckBox CityCheck) {
        this.CityCheck = CityCheck;
    }

    public JButton getReportButton() {
        return ReportButton;
    }

    public void setReportButton(JButton ReportButton) {
        this.ReportButton = ReportButton;
    }
    
    public void lookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private final control.MainViewControl myController;
    private final String APP_NAME = "Administrador de FRDNE";
    private final String FOLDER = "folder";
    private final String FILE = "file";
    private final String FRDNE = "FRDNE";
    private final String DESTINY = "DESTINY";
    private final String TXT = "TXT";
    
    // Variables declaration - do not modify                     
    private javax.swing.JCheckBox CityCheck;
    private javax.swing.JButton ComparatorAddressButton;
    private javax.swing.JTextField ComparatorAddressText;
    private javax.swing.JCheckBox CompareFRDNECheck;
    private javax.swing.JButton DestinyAddressButton;
    private javax.swing.JTextField DestinyAddressText;
    private javax.swing.JCheckBox DestinyFoldersCheck;
    private javax.swing.JButton FRDNEAddressButton;
    private javax.swing.JTextField FRDNEAddressText;
    private javax.swing.JLabel GlobalStateLabel;
    private javax.swing.JButton ReportButton;
    private javax.swing.JButton RestartButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
