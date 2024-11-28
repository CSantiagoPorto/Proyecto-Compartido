import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class TeacherWindow extends JFrame {
    private JComboBox<String> ModulosComboBox;
    private JTextField NotaTextField;
    private JButton Guardarbtn;
    private JButton CerrarSesionbtn;
    private JComboBox<String> AlumnosComboBox;
    private JTextArea AlumnosTextArea;

    //Creo unos ArrayList para poder poner alumnos de prueba
    private ArrayList<String> alumnosDesarrollo;
    private ArrayList<String> alumnosAcceso;
    private ArrayList<String> alumnosProgramacion;


    public TeacherWindow() {
        getContentPane().setBackground(new Color(176, 224, 230));
        setIconImage(Toolkit.getDefaultToolkit().getImage(TeacherWindow.class.getResource("/imagenes/logo.png")));
        
        setTitle("Gestión de Notas - Profesor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        //Creo un array pàra cada asignatura y meto alumnos de prueba
        alumnosDesarrollo = new ArrayList<>();
        alumnosDesarrollo.add("Pepe Perez");
        alumnosDesarrollo.add("Ana Gómez");

        alumnosAcceso = new ArrayList<>();
        alumnosAcceso.add("Juan Martínez");
        alumnosAcceso.add("María López");

        alumnosProgramacion = new ArrayList<>();
        alumnosProgramacion.add("Luis García");
        alumnosProgramacion.add("Laura Torres");
        

        // Desplegable para seleccionar el módulo
        JLabel moduloLabel = new JLabel("Módulo:");
        moduloLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        moduloLabel.setBounds(30, 30, 80, 25);
        getContentPane().add(moduloLabel);

        ModulosComboBox = new JComboBox<>(new String[]{"Desarrollo de Interfaces", "Acceso de Datos", "Programación"});
        ModulosComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ModulosComboBox.setBounds(105, 30, 180, 25);
        getContentPane().add(ModulosComboBox);

        // Etiqueta para la lista de alumnos
        JLabel AlumnosLabel = new JLabel("Alumnos:");
        AlumnosLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        AlumnosLabel.setBounds(30, 70, 80, 25);
        getContentPane().add(AlumnosLabel);

        // Recuadro donde aparecerán los alumnos (sin lógica aún asociada)
        AlumnosTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(AlumnosTextArea);
        scrollPane.setBounds(120, 70, 150, 100);
        getContentPane().add(scrollPane);
        
        

        // Campo de texto para la nota
        JLabel NotaLabel = new JLabel("Nota:");
        NotaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        NotaLabel.setBounds(90, 189, 43, 25);
        getContentPane().add(NotaLabel);

        NotaTextField = new JTextField();
        NotaTextField.setBounds(143, 190, 106, 25);
        getContentPane().add(NotaTextField);

        // Botón para guardar la nota (Falta asociar el alumno al que pertenece la nota)
        Guardarbtn = new JButton("Guardar");
        Guardarbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Guardarbtn.setBounds(84, 261, 100, 25);
        getContentPane().add(Guardarbtn);
        
        Guardarbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//La idea es que aquí ya está seleccionado el módulo ygetSelectedItem() nos devuelve el elemento seleccionado en el ComboBox
        		 String moduloSeleccionado = (String) ModulosComboBox.getSelectedItem();
                 String notaIngresada = NotaTextField.getText();
                 JOptionPane.showMessageDialog(null,
                         "Nota guardada:\n" +
                         "Módulo: " + moduloSeleccionado + "\n" +
                         "Nota: " + notaIngresada);

        	}
        });
		
		 //Necesitamos saber de qué asignatura es la nota
        ModulosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moduloSeleccionado = (String) ModulosComboBox.getSelectedItem();
                //Hago un casteo, porque necesito que sean String para guardarlo en moduloSleccionado
                ArrayList<String> alumnosActuales = new ArrayList<>();
                if (moduloSeleccionado.equals("Desarrollo de Interfaces")) {
                    alumnosActuales = alumnosDesarrollo;
                } else if (moduloSeleccionado.equals("Acceso de Datos")) {
                    alumnosActuales = alumnosAcceso;
                } else if (moduloSeleccionado.equals("Programación")) {
                    alumnosActuales = alumnosProgramacion;
                }

                AlumnosTextArea.setText(""); 
                for (String alumno : alumnosActuales) {
                    AlumnosTextArea.append(alumno + "\n");
                }
            }
        });
        // Botón para cerrar sesión
        CerrarSesionbtn = new JButton("Cerrar Sesión");
        CerrarSesionbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        CerrarSesionbtn.setBounds(194, 261, 120, 25);
        getContentPane().add(CerrarSesionbtn);

        CerrarSesionbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        TeacherWindow teacherWindow = new TeacherWindow();
        teacherWindow.setVisible(true);
    }
}

