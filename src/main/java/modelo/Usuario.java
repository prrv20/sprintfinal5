package modelo;

public class Usuario {
	
	private int id;
	private String run;
	private String nombreCompleto;
	private String fechaNacimiento;
	private String telefono;
	private String direccion;
	private String comuna;
	private String afp;
	private String sistemaSalud;
	private String fechaIngreso;
	private String titulo;
	private String area;
	private String experiencia;
	private String tipoUsuario;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int id, String run, String nombreCompleto, String fechaNacimiento, String telefono,
			String direccion, String comuna, String afp, String sistemaSalud, String fechaIngreso, String titulo,
			String area, String experiencia, String tipoUsuario) {
		this.id = id;
		this.run = run;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.comuna = comuna;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.fechaIngreso = fechaIngreso;
		this.titulo = titulo;
		this.area = area;
		this.experiencia = experiencia;
		this.tipoUsuario = tipoUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public String getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", run=" + run + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + ", direccion=" + direccion + ", comuna=" + comuna
				+ ", afp=" + afp + ", sistemaSalud=" + sistemaSalud + ", fechaIngreso=" + fechaIngreso + ", titulo="
				+ titulo + ", area=" + area + ", experiencia=" + experiencia + ", tipoUsuario=" + tipoUsuario + "]";
	}


	}
	
	


