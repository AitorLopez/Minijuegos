package clases;

public class Usuario {

	private String nick;
	private String contrase�a;
	private String nombre;
	private String apellidos;
	private String correo;
	
	public Usuario() {
		
	}

	public Usuario(String nick, String contrase�a, String nombre,
			String apellidos, String correo) {
		super();
		this.nick = nick;
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
	
}
