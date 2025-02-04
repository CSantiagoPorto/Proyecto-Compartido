package BaseDatos;
 
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;
 
import javax.naming.spi.DirStateFactory.Result;

import javax.swing.JOptionPane;
 
import com.mysql.jdbc.Statement;
 
public class GestionBD {

	private Conexion conexion=new Conexion();

	private Connection con;

	private Statement st;

	private ResultSet resultado;

	
	//REVISADO
	public boolean insertarAlumno(String dni, String nombre, String apellidos, String direccion, String pass) throws SQLException {

		boolean insertado = false;

		con=conexion.getConexion();

		String sql="insert into alumnos (DNI,NOMBRE,APELLIDOS,DIRECCION,PASSWORD) values ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+pass+"')";

		try {

			st=(Statement) con.createStatement();

			int confirmar = st.executeUpdate(sql);

			if (confirmar == 1){

				insertado = true;

			}

			st.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return insertado;

	}
	//REVISADO
	public boolean insertarProfesor(String dni, String nombre, String apellidos, String direccion, String pass) throws SQLException {

		boolean insertado = false;

		con=conexion.getConexion();

		String sql="insert into profesores (DNI,NOMBRE,APELLIDOS,DIRECCION,PASSWORD) values ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+pass+"')";

		try {

			st=(Statement) con.createStatement();

			int confirmar = st.executeUpdate(sql);

			if (confirmar == 1){

				insertado = true;

			}

			st.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return insertado;

	}

	/*public boolean insertarCiclo(String codigo, String nombre, String familia, String titulacion, String horas) throws SQLException {

		boolean insertado = false;

		con=conexion.getConexion();

		String sql="insert into ciclosformativos (CODIGO,NOMBRE,FAMILIA,TITULACION,HORAS) values ('"+codigo+"','"+nombre+"','"+familia+"','"+titulacion+"','"+horas+"')";

		try {

			st=(Statement) con.createStatement();

			int confirmar = st.executeUpdate(sql);

			if (confirmar == 1){

				insertado = true;

			}

			st.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return insertado;

	}*/
	
	
	//revisado y adaptado
	public boolean insertarAsignatura(String id_asignatura,  String denominacion, String horas, String descripcion) throws SQLException {

		boolean insertado = false;

		con=conexion.getConexion();

		String sql="insert into asignaturas (ID_ASIGNATURA,DENOMINACION,HORAS,DESCRIPCION) values ('"+id_asignatura+"','"+denominacion+"','"+horas+"','"+descripcion+"')";

		try {

			st=(Statement) con.createStatement();

			int confirmar = st.executeUpdate(sql);

			if (confirmar == 1){

				insertado = true;

			}

			st.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return insertado;

	}
	//REVISADO
	public int modificarAlumno(String dni_alumno, String nombre, String apellidos, String direccion, String pass) throws SQLException {

		int confirmar=0;

		con=conexion.getConexion();

		String sql="update alumnos set DNI='"+dni_alumno+"', NOMBRE='"+nombre+"', APELLIDOS='"+apellidos+"', DIRECCION='"+direccion+"', PASS='"+pass+"' where DNI="+dni_alumno+"";

		try {

			st=(Statement) con.createStatement();

			confirmar=st.executeUpdate(sql);

			st.close();

			con.close();

		}  catch (SQLException e) {

			e.printStackTrace();

		}

		return confirmar;

	}
//REVISADO
	public int modificarProfesor(String dni_profesor, String nombre, String apellidos, String direccion, String pass) throws SQLException {

		int confirmar=0;

		con=conexion.getConexion();

		String sql="update profesores set DNI='"+dni_profesor+"', NOMBRE='"+nombre+"', APELLIDOS='"+apellidos+"', DIRECCION='"+direccion+"', PASS='"+pass+"' where DNI="+dni_profesor+"";

		try {

			st=(Statement) con.createStatement();

			confirmar=st.executeUpdate(sql);

			st.close();

			con.close();

		}  catch (SQLException e) {

			e.printStackTrace();

		}

		return confirmar;

	}
 
/*public int modificarCiclo(String codigo, String nombre, String familia, String titulacion, String horas) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="update ciclosformativos set CODIGO='"+codigo+"', NOMBRE='"+nombre+"', FAMILIA='"+familia+"', TITULACION='"+titulacion+"', HORAS='"+horas+"' where CODIGO="+codigo+"";
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	*/
	/*public int modificarModulo(String clave, String ciclo, String denominacion, String horasc, String curso, String horass) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="update modulos set CLAVE='"+clave+"', CICLO='"+ciclo+"', DENOMINACION='"+denominacion+"', HORASC='"+horasc+"', CURSO='"+curso+"', HORASS='"+horass+"' where CLAVE="+clave+"";
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}*/
	//REVISADO
	public int eliminarAlumno(String dni) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from alumnos where DNI="+dni;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	//REVISADO
	public int eliminarProfesor(String dni_profesor) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from profesores where DNI="+dni_profesor;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	/*public int eliminarCiclo(String codigo) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from ciclosformativos where CODIGO="+codigo;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int eliminarModulo(String clave) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from modulos where CLAVE="+clave;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}*/
	//revisado y cambiado
	public boolean comprobarAlumno(String dni_alumno, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos WHERE DNI='"+dni_alumno+"'and PASSWORD='"+pass+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	//revisado y cambiado
	public boolean comprobarProfesor(String dni_profesor, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores WHERE DNI='"+dni_profesor+"'and PASS='"+pass+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	
	/*public boolean comprobarGerencia(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM gerencia WHERE DNI='"+dni+"'and PASSWORD='"+pass+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
 
public boolean comprobarCiclos(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos WHERE DNI='"+dni+"'and PASSWORD='"+pass+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}*/
	//REVISADO Y ADAPTADO
	public boolean buscarAlumno(String dni_alumno) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos WHERE DNI='"+dni_alumno+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	//REVISADO Y ADAPTADO
	public boolean buscarProfesor(String dni_profesor) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores WHERE DNI='"+dni_profesor+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	
	/*public boolean buscarCiclo(String codigo) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos WHERE CODIGO='"+codigo+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}*/
	//REVISADO
	public boolean buscarAsignatura(String id_asignatura) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM modulos WHERE ID_ASIGNATURA='"+id_asignatura+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	//REVISADO
	public ResultSet BuscarAlumno(String dni_alumno) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos WHERE DNI='"+dni_alumno+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet BuscarProfesor(String dni_profesor) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores WHERE DNI='"+dni_profesor+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/*public ResultSet devolverCiclo(String codigo) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos WHERE CODIGO='"+codigo+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}*/
	//REVISADO
	public ResultSet BuscarAsignatura(String id_asignatura) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM modulos WHERE CLAVE='"+id_asignatura+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	//REVISADO
	public ResultSet BuscarTodosAlumnos() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	//revisado
	public ResultSet BuscarTodosProfesores() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	/*public ResultSet devolverCiclos() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}*/
	
	public ResultSet BuscarTodosAsignaturas() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM modulos";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
 
 