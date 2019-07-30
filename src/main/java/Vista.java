
import com.panamahitek.ArduinoException;
import jssc.SerialPortException;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.sun.prism.paint.Color;
import static java.awt.Color.*;
import javax.swing.JFrame;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Vista extends javax.swing.JFrame {
    
    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    SerialPortEventListener comListener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent arg0) {
            try {
                if(arduino.isMessageAvailable()) {
                    String opcion = arduino.printMessage();
                    int op = Integer.parseInt(opcion);
                    switch(op) {
                        case 1:
                            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/H5.png")));
                            //CambiaTextoLabel("/HunzahuaTexto.txt");
                            break;
                        case 2:
                            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/N1.png")));
                            break;
                        case 3:
                            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/S1.png")));
                            break;
                        case 4:
                            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/T4.png")));
                            break;
                        case 5:
                            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Q3.png")));
                            break;                          
                    }//end switch */
                }
            } catch (SerialPortException | ArduinoException e) {
                e.printStackTrace();
            }
        }
    };       
    
    public Vista() {
        initComponents();
        textF.setEditable(false);
        textF.setLineWrap(true);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            arduino.arduinoRX("COM3", 9600, comListener);
		} catch (ArduinoException | SerialPortException e) {
			e.printStackTrace();
		}
    }
    
    public void CambiaTextoLabel(String ruta) {
        String texto = "";    
        Scanner s;
        
        try {
            File f = new File(getClass().getResource(ruta).toURI());
            InputStreamReader input = new InputStreamReader(new FileInputStream(f));
            s = new Scanner(f);
            while(s.hasNextLine()){
                texto += s.nextLine();
                texto += "\n";
                System.out.println(texto);
            }
            s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hola" + texto);
            textF.setText(texto);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        textF = new javax.swing.JTextArea();
        labelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        scroll.setBorder(null);

        textF.setColumns(20);
        textF.setRows(5);
        textF.setBorder(null);
        textF.setOpaque(false);
        scroll.setViewportView(textF);

        jPanel1.add(scroll);
        scroll.setBounds(320, 200, 540, 260);

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nemequene0.png"))); // NOI18N
        labelImagen.setText("jLabel1");
        labelImagen.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.add(labelImagen);
        labelImagen.setBounds(0, 0, 1402, 589);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea textF;
    // End of variables declaration//GEN-END:variables
}
