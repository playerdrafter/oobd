/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SKDSSwingUpload.java
 *
 * Created on 30.04.2011, 16:21:35
 */

package skdsswing;
import java.awt.event.WindowEvent;
import org.jdesktop.application.Action;
/**
 *
 * @author maziar
 */
public class SKDSSwingUpload extends javax.swing.JDialog {

    /** Creates new form SKDSSwingUpload */
    private static boolean openSelected = false;;

    public static boolean getOpenSelected(){
        return openSelected;
    }
    public static void setOpenSelected(boolean value){
        openSelected = value;
    }
    public SKDSSwingUpload(java.awt.Frame parent) {
        super(parent);
        initComponents();
       

        if((SDKSSwingFileExplorer.getFileName()==null) ){
            TFFileName.setText("No File selected!!!!");
            TFFilePath.setText("No file available");
            ButtonSend.setEnabled(false);
            // SDKSSwingFileExplorer.getFileName()
        }
        else{
            TFFileName.setText(SDKSSwingFileExplorer.getFileName());
            TFFilePath.setText(SDKSSwingFileExplorer.getFilePath());
            ButtonSend.setEnabled(true);
        }

    }
     @Action public void closeUploadDialog() {
       openSelected = true;
       dispose();
       
    }

  

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonSend = new javax.swing.JButton();
        ButtonClose = new javax.swing.JButton();
        TFFileName = new javax.swing.JTextField();
        TFFilePath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skdsswing.SKDSSwingApp.class).getContext().getResourceMap(SKDSSwingUpload.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        ButtonSend.setText(resourceMap.getString("ButtonSend.text")); // NOI18N
        ButtonSend.setName("ButtonSend");

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(skdsswing.SKDSSwingApp.class).getContext().getActionMap(SKDSSwingUpload.class, this);
        ButtonClose.setAction(actionMap.get("closeUploadDialog")); // NOI18N
        ButtonClose.setText(resourceMap.getString("ButtonClose.text")); // NOI18N
        ButtonClose.setName("ButtonClose"); // NOI18N

        TFFileName.setEditable(false);
        TFFileName.setText(resourceMap.getString("TFFileName.text")); // NOI18N
        TFFileName.setName("TFFileName"); // NOI18N

        TFFilePath.setEditable(false);
        TFFilePath.setText(resourceMap.getString("TFFilePath.text")); // NOI18N
        TFFilePath.setName("TFFilePath"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jRadioButton1.setSelected(true);
        jRadioButton1.setText(resourceMap.getString("jRadioButton1.text")); // NOI18N
        jRadioButton1.setEnabled(false);
        jRadioButton1.setName("jRadioButton1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 475, Short.MAX_VALUE)
                        .addComponent(ButtonClose)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TFFilePath, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFFileName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(182, 182, 182))))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jRadioButton1)
                .addContainerGap(440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TFFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSend)
                    .addComponent(ButtonClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonClose;
    private javax.swing.JButton ButtonSend;
    private javax.swing.JTextField TFFileName;
    private javax.swing.JTextField TFFilePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
    
}
