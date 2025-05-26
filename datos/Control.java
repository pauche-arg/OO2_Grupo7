package datos;

import java.time.LocalDate;

public class Control {
	private int idControl;
	private Ticket ticket;
	private Funcion funcion;
	private Empleado empleado;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private boolean finalizado;
	
	public Control() {}
	
	public Control(Ticket ticket, Funcion funcion, Empleado empleado, LocalDate fechaEntrada,
			LocalDate fechaSalida) {
		this.ticket = ticket;
		this.funcion = funcion;
		this.empleado = empleado;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.finalizado = false;
	}

	public int getIdControl() {
		return idControl;
	}

	private void setIdControl(int idControl) {
		this.idControl = idControl;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
	
	

}
