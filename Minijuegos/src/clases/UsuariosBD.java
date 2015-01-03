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
	
	/*SELECT Nick, Puntuacion FROM PARTIDA where idj=1
	order by Puntuacion desc limit 10;*/
	public static String topTenJuegoNick(int idj){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String nicks=null;
		String sql = null;
		try {
			sql = "select Nick from PARTIDA where IDJ = '"+idj+"' order by Puntuacion desc limit 10";
			rs = stat.executeQuery(sql);
			nicks=rs.getString(1);
			System.out.println(nicks);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR topTenJuegoNick: "+sql);
			System.out.println("ERROR topTenJuegoNick: "+e.getMessage());
		}
		return nicks;
	}
	
	public static int topTenJuegoPuntuacion(int idj){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		int scores=0;
		String sql = null;
		try {
			sql = "select Nick from PARTIDA where IDJ = '"+idj+"' order by Puntuacion desc limit 10";
			rs = stat.executeQuery(sql);
			scores=rs.getInt(1);
			System.out.println(scores);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR topTenJuegoPuntuacion: "+sql);
			System.out.println("ERROR topTenJuegoPuntuacion: "+e.getMessage());
		}
		return scores;
	}
	//SELECT MAX(PUNTUACION) FROM PARTIDA WHERE NICK='A'
	public static int JuegoMasUtilizado(String nick){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		int scores=0;
		String sql = null;
		try {
			sql = "select max(PUNTUACION) from PARTIDA where nick = '"+nick+"'";
			rs = stat.executeQuery(sql);
			scores=rs.getInt(1);
			System.out.println(scores);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR JuegoMasUtilizado: "+sql);
			System.out.println("ERROR JuegoMasUtilizado: "+e.getMessage());
		}
		return scores;
	}
	/*SELECT  Puntuacion FROM PARTIDA
	order by Puntuacion desc limit 10;*/
	public static int topTenGeneralPuntuacion(){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		int score=0;
		String sql = null;
		try {
			sql = "select Puntuacion from PARTIDA order by PUNTUACION desc limit 10";
			rs = stat.executeQuery(sql);
			score=rs.getInt(1);
			System.out.println(score);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR topTenGeneralPuntuacion: "+sql);
			System.out.println("ERROR topTenGeneralPuntuacion: "+e.getMessage());
		}
		return score;
	}
	
	/*SELECT  Nick FROM PARTIDA
	order by Puntuacion desc limit 10;*/
	public static String topTenGeneralNick(){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String nick=null;
		String sql = null;
		try {
			sql = "select Nick from PARTIDA order by PUNTUACION desc limit 10";
			rs = stat.executeQuery(sql);
			nick=rs.getString(1);
			System.out.println(nick);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR topTenGeneralNick: "+sql);
			System.out.println("ERROR topTenGeneralNick: "+e.getMessage());
		}
		return nick;
	}
	/*SELECT  Nick FROM PARTIDA where idj=1
	order by Puntuacion desc limit 10;*/
	public static String topTenIndividualNick(int idj){
		Usuario u=null;
		Statement stat = BaseDeDatos.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String nick=null;
		String sql = null;
		try {
			sql = "select Nick from PARTIDA where idj='"+idj+"'order by PUNTUACION desc limit 10";
			rs = stat.executeQuery(sql);
			nick=rs.getString(1);
			System.out.println(nick);
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR topTenIndividualNick: "+sql);
			System.out.println("ERROR topTenIndividualNick: "+e.getMessage());
		}
		return nick;
	}
}
