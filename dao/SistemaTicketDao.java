package dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ticket;
import datos.Usuario;
import negocio.TicketABM;

public class SistemaTicketDao {
	private static Session session;
	private Transaction tx;
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	/*public int generarTicket(Usuario objeto, String titulo, String desc) throws Exception {
		TicketABM abm = new TicketABM();
		return abm.agregar(titulo, desc, LocalDate.now(), "abierto", objeto, null);
	}*/

}
