import java.awt.EventQueue;

import javax.swing.*;
public class Entrada {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                	//Me he traído esto desde la ventana de registro
                    // Salta la ventana de Login
                    LoginWindow frame = new LoginWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}

}
