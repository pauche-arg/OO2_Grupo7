package datos;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private int idTicket;
	private String titulo;
	private String descripcion;
	private LocalDate fechaCreacion;
	private LocalDate fechaCierre;
	private Estado estado;
	private Usuario usuarioCreador;
	private Prioridad prioridad;
	private List<Control> controles; 
	
	public Ticket() {}
	
	public Ticket(String titulo, String descripcion,
			Usuario usuarioCreador) throws Exception {
		validarTitulo(titulo);
		validarDescripcion(descripcion);
		validarUsuario(usuarioCreador);
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = LocalDate.now();
		this.fechaCierre = null;
		this.estado = Estado.PENDIENTE;
		this.usuarioCreador = usuarioCreador;
		this.prioridad = Prioridad.SIN_ASIGNAR;
	}
	
	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public List<Control> getControles() {
		return controles;
	}

	public void setControles(List<Control> controles) {
		this.controles = controles;
	}

	public static void validarTitulo(String titulo) throws Exception {
		 if (titulo == null ||titulo.trim().isEmpty()) {
		        throw new Exception("El título no puede estar vacío.");
		    }
		 
		 if (!titulo.matches(".*[a-zA-Z].*")) {
			    throw new Exception("El título debe contener al menos una letra.");
			}
	}
	
	public static void validarDescripcion(String descripcion) throws Exception {
		 if (descripcion == null || descripcion.trim().isEmpty()) {
		        throw new Exception("La descripción no puede estar vacía.");
		    }
		 
		 if (!descripcion.matches(".*[a-zA-Z].*")) {
			    throw new Exception("La descripción debe contener al menos una letra.");
			}
	}
	
	public static void validarUsuario(Usuario usuario) throws Exception {
		if (usuario == null) {
	        throw new Exception("Debe especificarse un usuario creador para el ticket.");
	    }
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
	    this.estado = estado;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}
	
	
	public boolean estaResuelto() {
		return this.getEstado() == Estado.RESUELTO;
	}
	
	public boolean esDelUsuario(Usuario u) {
		return this.usuarioCreador.equals(u);
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", estado=" + estado
				+ ", prioridad=" + prioridad + ", controles=" + controles + "]";
	}
	
	
	
	
}


