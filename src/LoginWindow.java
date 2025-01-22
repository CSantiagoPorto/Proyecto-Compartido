import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class LoginWindow extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginbtn, Limpiarbtn, Salirbtn;
    private JButton logo;
    private JLabel labelCargo;
	private JComboBox cbCargo;
	private JButton btnRegistrar;

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
        userField.setBounds(129, 32, 179, 25);
        getContentPane().add(userField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(30, 70, 89, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(129, 67, 179, 25);
        getContentPane().add(passwordField);

        // Botón de iniciar sesión
        loginbtn = new JButton("Iniciar Sesión");
        loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        loginbtn.setBounds(30, 165, 120, 25);
        getContentPane().add(loginbtn);

        // Botón de limpiar campos
        Limpiarbtn = new JButton("Limpiar");
        Limpiarbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        Limpiarbtn.setBounds(367, 165, 80, 25);
        getContentPane().add(Limpiarbtn);

        // Botón de salir
        Salirbtn = new JButton("Salir");
        Salirbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        Salirbtn.setBounds(206, 165, 80, 25);
        getContentPane().add(Salirbtn);
        
        logo = new JButton("");
        logo.setIcon(new ImageIcon(LoginWindow.class.getResource("/imagenes/logo.png")));
        logo.setBounds(356, 30, 113, 79);
        getContentPane().add(logo);
        
        JComboBox cbCargo = new JComboBox();
        cbCargo.setBounds(129, 124, 179, 21);
        getContentPane().add(cbCargo);
        
        JLabel labelCargo = new JLabel("Cargo");
        labelCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCargo.setBounds(30, 128, 89, 17);
        getContentPane().add(labelCargo);
        cbCargo.addItem("Seleccione");
		cbCargo.addItem("Alumno");
		cbCargo.addItem("Profesor");
		getContentPane().add(cbCargo);
		
		//Botón registrase
		
		btnRegistrar = new JButton("¿No tiene cuenta? Regístrese!");
		btnRegistrar.setForeground(Color.BLUE);
		btnRegistrar.setBounds(141, 206, 213, 21);
		getContentPane().add(btnRegistrar);

        // Lógica del botón "Iniciar Sesión"
        loginbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String cargo =(String)cbCargo.getSelectedItem();
                String user = userField.getText();
                String password = new String(passwordField.getPassword());
                
                //Comprobamos que ha puesto el cargo
                if (cbCargo.getSelectedIndex()==0) {//Ver clase 4
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un cargo.");
                        
                //Añadir clase Usuario de la que hereden alumno y profesor y compruebo sobre 
                        //El objeto. Creamos ventana, la hacemos visible y dispose().
                        //Una ventana para alumno y otra para profesor
                }

                // Validación para alumno
                if (user.equalsIgnoreCase("alumno") && password.equals("uem")) {
                    new StudentWindow().setVisible(true);
                    dispose();
                }
                // Validación para profesor
                else if (user.equalsIgnoreCase("profesor") && password.equals("uem")) {
                    new TeacherWindow().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //  botón limpiar
        Limpiarbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passwordField.setText("");
            }
        });
        //Boton para registrar
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Registro ventanaRegistro = new Registro();
                ventanaRegistro.setVisible(true);
                // El dispose() hace que se cierre la ventana de logeo
                dispose();
            }
        });

        // botón "Salir"
        Salirbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }
}
