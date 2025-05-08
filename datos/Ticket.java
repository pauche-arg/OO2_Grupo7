package datos;

import java.time.LocalDate;

public class Ticket {
	private int idTicket;
	private String titulo;
	private String descripcion;
	private LocalDate fechaCreacion;
	private String estado;
	private Usuario usuarioCreador;
	private Empleado empleadoAsignado;
	
	public Ticket() {}
	
	public Ticket(String titulo, String descripcion, LocalDate fechaCreacion, String estado,
			Usuario usuarioCreador, Empleado empleadoAsignado) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.usuarioCreador = usuarioCreador;
		this.empleadoAsignado = empleadoAsignado;
	}

	public int getIdTicket() {
		return idTicket;
	}

	private void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public Empleado getEmpleadoAsignado() {
		return empleadoAsignado;
	}

	public void setEmpleadoAsignado(Empleado empleadoAsignado) {
		this.empleadoAsignado = empleadoAsignado;
	}

	@Override
	public String toString() {
		return "Ticket [titulo=" + titulo + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion
				+ ", estado=" + estado + ", usuarioCreador=" + usuarioCreador + ", empleadoAsignadoId=" + (empleadoAsignado != null ? empleadoAsignado.getIdUsuario() : "null")
				+ "]"
				+ ", estado=" + estado + ", usuarioCreador=" + usuarioCreador + "]\n";
	}
	
	public boolean esAsignado() {
		return this.empleadoAsignado != null;
	}
	
	public boolean estaResuelto() {
		return "resuelto".equalsIgnoreCase(this.estado);
	}
	
	public boolean esDelUsuario(Usuario u) {
		return this.usuarioCreador.equals(u);
	}
	
	
	
	
}


