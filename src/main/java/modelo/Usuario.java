package modelo;

public class Usuario {
	private String run;
	private String nombreCompleto;
	private String FechaNacimiento;
	private String telefono;
	private String afp;
	private String sistemaDeSalud;
	private String direccion;
	private String comuna;
	private String titulo;
	private String fechaIngreso;
	private String area;
	private String experienciaPrevia;
	private String tipoUsuario;
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	public Usuario(String run, String nombreCompleto, String fechaNacimiento, String telefono, String afp,
			String sistemaDeSalud, String direccion, String comuna, String titulo, String fechaIngreso, String area,
			String experienciaPrevia, String tipoUsuario) {
		super();
		this.run = run;
		this.nombreCompleto = nombreCompleto;
		this.FechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaDeSalud = sistemaDeSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
		this.tipoUsuario = tipoUsuario;
		
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
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getAfp() {
		return afp;
	}
	public void setAfp(String afp) {
		this.afp = afp;
	}
	public String getSistemaDeSalud() {
		return sistemaDeSalud;
	}
	public void setSistemaDeSalud(String sistemaDeSalud) {
		this.sistemaDeSalud = sistemaDeSalud;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}
	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public String toString() {
		return "Usuario [run=" + run + ", nombreCompleto=" + nombreCompleto + ", FechaNacimiento=" + FechaNacimiento
				+ ", telefono=" + telefono + ", afp=" + afp + ", sistemaDeSalud=" + sistemaDeSalud + ", direccion="
				+ direccion + ", comuna=" + comuna + ", titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + ", area="
				+ area + ", experienciaPrevia=" + experienciaPrevia + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
}
