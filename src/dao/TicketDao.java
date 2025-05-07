package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Ticket;
import datos.Usuario;

public class TicketDao {
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
	
	///SIN DETALLES
	public Ticket traeSinUsuario(int idTicket) {
		Ticket objeto = null;
		try {
			iniciaOperacion();
			objeto = (Ticket) session.get(Ticket.class, idTicket);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public int agregar(Ticket objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	
	public void eliminar(Ticket objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	///LISTA DE TODOS LOS TICKETS DE UN USUARIO
	public List<Ticket> traer(Usuario u){
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			String hQl = "from Ticket t inner join fetch t.usuarioCreador u where u.idUsuario";
			lista = session.createQuery(hQl,Ticket.class).setParameter("idUsuario", u.getIdUsuario()).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	////TRAER TICKET CON DETALLES
	public Ticket traer(int idTicket) {
		Ticket objeto = null;
		try {
			iniciaOperacion();
			String hQL = "from Ticket t inner join fetch t.usuarioCreador u where t.idTicket=:idTicket";
			objeto = (Ticket)session.createQuery(hQL).setParameter("idTicket", idTicket).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public void asignarTicket(int id, Empleado emp) {
		traeSinUsuario(id).setEmpleadoAsignado(emp);
	}
	
	

}
