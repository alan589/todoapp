/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package TodoApp.view;

import TodoApp.controller.TaskController;
import TodoApp.model.Project;
import TodoApp.model.Task;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */

public class TaskDialogScreen extends javax.swing.JDialog {

    TaskController taskController;
    Project project;

    public void setProject(Project project) {
        this.project = project;
    }

    public TaskDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        taskController = new TaskController();
        hideErrorLabels();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelToolbar = new javax.swing.JPanel();
        jLabelToolbarTitle = new javax.swing.JLabel();
        jLabelToolbarSave = new javax.swing.JLabel();
        jLabelTaskName = new javax.swing.JLabel();
        jLabelTaskDescription = new javax.swing.JLabel();
        jLabelTaskPrazo = new javax.swing.JLabel();
        jLabelTaskNotas = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jScrollPaneDescription = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jFormattedTextFieldPrazo = new javax.swing.JFormattedTextField();
        jScrollPaneNotas = new javax.swing.JScrollPane();
        jTextAreaNotas = new javax.swing.JTextArea();
        jLabelNameError = new javax.swing.JLabel();
        jLabelDeadlineError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelToolbar.setBackground(new java.awt.Color(165, 201, 202));

        jLabelToolbarTitle.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabelToolbarTitle.setForeground(new java.awt.Color(57, 91, 100));
        jLabelToolbarTitle.setText("Tasks");

        jLabelToolbarSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelToolbarSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelToolbarSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelToolbarSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelToolbarSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolbarLayout = new javax.swing.GroupLayout(jPanelToolbar);
        jPanelToolbar.setLayout(jPanelToolbarLayout);
        jPanelToolbarLayout.setHorizontalGroup(
            jPanelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolbarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelToolbarTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelToolbarSave)
                .addGap(36, 36, 36))
        );
        jPanelToolbarLayout.setVerticalGroup(
            jPanelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelToolbarLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolbarSave)
                    .addComponent(jLabelToolbarTitle))
                .addGap(21, 21, 21))
        );

        jLabelTaskName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelTaskName.setText("Nome");

        jLabelTaskDescription.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelTaskDescription.setText("Descrição");

        jLabelTaskPrazo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelTaskPrazo.setText("Prazo");

        jLabelTaskNotas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelTaskNotas.setText("Notas");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPaneDescription.setViewportView(jTextAreaDescription);

        jFormattedTextFieldPrazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jTextAreaNotas.setColumns(20);
        jTextAreaNotas.setRows(5);
        jScrollPaneNotas.setViewportView(jTextAreaNotas);

        jLabelNameError.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabelNameError.setForeground(new java.awt.Color(255, 0, 51));
        jLabelNameError.setText("Campo obrigatório");

        jLabelDeadlineError.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabelDeadlineError.setForeground(new java.awt.Color(255, 0, 51));
        jLabelDeadlineError.setText("Campo obrigatório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFormattedTextFieldPrazo)
                    .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneNotas, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTaskName)
                            .addComponent(jLabelTaskDescription)
                            .addComponent(jLabelTaskPrazo)
                            .addComponent(jLabelTaskNotas)
                            .addComponent(jLabelNameError)
                            .addComponent(jLabelDeadlineError))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTaskName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNameError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTaskDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTaskPrazo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabelDeadlineError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTaskNotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNotas, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelToolbarSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelToolbarSaveMouseClicked
        // TODO add your handling code here:

        try {            
            if(isFieldsValid()){
                Task task = new Task();
                task.setName(jTextFieldNome.getText());
                task.setDescription(jTextAreaDescription.getText());
                task.setNotes(jTextAreaNotas.getText());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
                task.setDeadline(dateFormat.parse(jFormattedTextFieldPrazo.getText()));
                task.setCreateAt(new Date());
                task.setUpdateAt(new Date());

                task.setIdProject(project.getId());
                JOptionPane.showMessageDialog(rootPane, "Tarefa salva!");
                taskController.save(task);
                this.dispose();
            }
            else{
                hideErrorLabels();
                if(jTextFieldNome.getText().isEmpty())jLabelNameError.setVisible(true);
                if(jFormattedTextFieldPrazo.getText().isEmpty())jLabelDeadlineError.setVisible(true);
                    
                    //JOptionPane.showMessageDialog(rootPane, "Não é possível salvar a tarefa "
                    //   + "pois existem campos obrigatórios vazios");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } 

    }//GEN-LAST:event_jLabelToolbarSaveMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaskDialogScreen dialog = new TaskDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void hideErrorLabels(){
       jLabelDeadlineError.setVisible(false);
       jLabelNameError.setVisible(false);
    }
    
    boolean isFieldsValid(){
        return !(jTextFieldNome.getText().isEmpty() || jFormattedTextFieldPrazo.getText().isEmpty());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldPrazo;
    private javax.swing.JLabel jLabelDeadlineError;
    private javax.swing.JLabel jLabelNameError;
    private javax.swing.JLabel jLabelTaskDescription;
    private javax.swing.JLabel jLabelTaskName;
    private javax.swing.JLabel jLabelTaskNotas;
    private javax.swing.JLabel jLabelTaskPrazo;
    private javax.swing.JLabel jLabelToolbarSave;
    private javax.swing.JLabel jLabelToolbarTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelToolbar;
    private javax.swing.JScrollPane jScrollPaneDescription;
    private javax.swing.JScrollPane jScrollPaneNotas;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaNotas;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
