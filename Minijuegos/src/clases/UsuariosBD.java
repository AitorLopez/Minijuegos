package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UsuariosBD {
	
	public static Usuario buscarUsuariosBD(String nick, String contrase�a){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String sql = null;
		try {
			sql = "select * from usuario where nick = '"+nick+"' and contrase�a='"+contrase�a+"'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				u = new Usuario(rs.getString("nick"), rs.getString("contrase�a"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("correo electr�nico"));
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
	
	public static Usuario a�adirUsuariosBD(String nick, String contrase�a, String nombre, String apellidos, String correo){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		String sql = null;
		try {
			sql = "insert into Usuario values('"+nick+"','"+contrase�a+"','"+nombre+"','"+apellidos+"','"+correo+"')";
			int filas=stat.executeUpdate(sql);
			if(filas==1)
				u = new Usuario(nick,contrase�a,nombre,apellidos,correo);		
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR a�adirUsuarioABD: "+sql);
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
			//SELECT MAX(PUNTUACION) FROM PARTIDA WHERE IDJ=1;
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
	
	public static String recordPersonalJuego(int idj, String nick){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String sql = null;
		try {
			//SELECT MAX(PUNTUACION) FROM PARTIDA WHERE IDJ=1;
			sql = "select max(Puntuacion) from PARTIDA where IDJ = '"+idj+"' and nick='"+nick+"'";
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
}
