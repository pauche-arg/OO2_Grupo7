package test;

import datos.Estado;
import datos.Ticket;

public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();

		ticket.setEstado(Estado.ABIERTO);
		
		System.out.println(ticket.getEstado());
	}

}
