package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UsuariosBD {
	
	public static Usuario buscarUsuariosBD(String nick, String contraseña){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String sql = null;
		try {
			sql = "select * from usuario where nick = '"+nick+"' and contraseña='"+contraseña+"'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				u = new Usuario(rs.getString("nick"), rs.getString("contraseña"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("correo electrónico"));
			}
			
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR buscarUsuariosBD: "+sql);
			System.out.println("ERROR buscarUsuariosBD: "+e.getMessage());
		}
		return u;
	}
	
	public static Usuario añadirUsuariosBD(String nick, String contraseña, String nombre, String apellidos, String correo){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		String sql = null;
		try {
			sql = "insert into Usuario values('"+nick+"','"+contraseña+"','"+nombre+"','"+apellidos+"','"+correo+"')";
			int filas=stat.executeUpdate(sql);
			if(filas==1)
				u = new Usuario(nick,contraseña,nombre,apellidos,correo);		
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR añadirUsuarioABD: "+sql);
		}
		
		return u;
	}
	
	public static String recordMundialPartida(int idj){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String sql = null;
		try {
			sql = "select max(Puntuacion) from PARTIDA where IDJ = '"+idj+"'";
			rs = stat.executeQuery(sql);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR recordMundialPartida: "+sql);
			System.out.println("ERROR recordMundialPartida: "+e.getMessage());
		}
		return sql;
	}
	
	public static int recordPersonalJuego(int idj, String nick){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		int record=0;
		String sql = null;
		try {
			sql = "select max(Puntuacion) from PARTIDA where IDJ = '"+idj+"' and nick='"+nick+"'";
			rs = stat.executeQuery(sql);
			record=rs.getInt(1);
			System.out.println(record);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR recordPersonalJuego: "+sql);
			System.out.println("ERROR recordPersonalJuego: "+e.getMessage());
		}
		return record;
	}
	
	public static String ultimaFechaUsuarioJuega(int idj, String nick){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String fecha=null;
		String sql = null;
		try {
			sql = "select min(fecha) from PARTIDA where IDJ = '"+idj+"' and nick='"+nick+"'";
			rs = stat.executeQuery(sql);
			fecha=rs.getString(1);
			System.out.println(fecha);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR ultimaFechaUsuarioJuega: "+sql);
			System.out.println("ERROR ultimaFechaUsuarioJuega: "+e.getMessage());
		}
		return fecha;
	}
}
