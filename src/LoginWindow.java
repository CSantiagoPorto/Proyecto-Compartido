import javax.swing.*;

import model.Alumno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JComboBox<String> cbCargo;
    private JButton logo;

    public LoginWindow() {
    	setResizable(false);
    	getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
    	getContentPane().setBackground(new Color(176, 224, 230));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/imagenes/logo.png")));
        setTitle("Login");
        setSize(512, 274);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userLabel.setBounds(30, 30, 80, 25);
        getContentPane().add(userLabel);

        userField = new JTextField();
        userField.setBounds(120, 30, 200, 25);
        getContentPane().add(userField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(30, 70, 100, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 200, 25);
        getContentPane().add(passwordField);

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cargoLabel.setBounds(30, 110, 80, 25);
        getContentPane().add(cargoLabel);

        cbCargo = new JComboBox<>(new String[]{"Seleccione", "Alumno", "Profesor"});
        cbCargo.setBounds(120, 110, 200, 25);
        getContentPane().add(cbCargo);
        logo = new JButton("");
        logo.setIcon(new ImageIcon(LoginWindow.class.getResource("/imagenes/logo.png")));
        logo.setBounds(356, 30, 113, 79);
        getContentPane().add(logo);

        JButton loginbtn = new JButton("Iniciar Sesión");
        loginbtn.setBounds(181, 160, 150, 30);
        getContentPane().add(loginbtn);

        JButton limpiarbtn = new JButton("Limpiar");
        limpiarbtn.setBounds(30, 200, 100, 30);
        getContentPane().add(limpiarbtn);

        JButton salirbtn = new JButton("Salir");
        salirbtn.setBounds(389, 200, 80, 30);
        getContentPane().add(salirbtn);
        
        JButton btnRegistrar = new JButton("Registrese");
        btnRegistrar.setForeground(Color.BLUE);
        btnRegistrar.setBounds(206, 200, 100, 30);
        getContentPane().add(btnRegistrar);
        
       
        // Botón login
        loginbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarLogin();//Llamada al método validar login, comprueba contraseña
                //Y si todo está correcto cierra esta ventana y abre la de estudiante o profesor
            }
        });
        btnRegistrar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		new Registro().setVisible(true);
        	}
        });

        // Botón limpiar
        limpiarbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passwordField.setText("");
                cbCargo.setSelectedIndex(0);
            }
        });
        

        // Botón salir
        salirbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void validarLogin() {
        String cargo = (String) cbCargo.getSelectedItem();
        String user = userField.getText();
        String password = new String(passwordField.getPassword());

        if ("Seleccione".equals(cargo)) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cargo.");
            return;
        }

        if ("Alumno".equals(cargo) && "alumno".equalsIgnoreCase(user) && "uem".equals(password)) {
            Alumno alumno = new Alumno("Carla", "uem");
            alumno.agregarNota("Desarrollo de Interfaces", 6.5);
            alumno.agregarNota("Acceso de Datos", 8.0);
            alumno.agregarNota("Programación", 9.3);

            new StudentWindow(alumno).setVisible(true);
            dispose();
        } else if ("Profesor".equals(cargo) && "profesor".equalsIgnoreCase(user) && "uem".equals(password)) {
            new TeacherWindow().setVisible(true);
            //Si todo está correcto abre la ventana profesor
            dispose();//cierra esta ventana
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        }
    }
    
}
