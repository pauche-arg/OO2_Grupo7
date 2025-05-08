package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Ticket;
import datos.Usuario;
import dao.UsuarioDao;
import dao.EmpleadoDao;

public class TicketDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos de TicketDao.", he);
	}
	
	public int agregar(Ticket objeto) {
		int id = 0;
		try {
			iniciaOperacion();			
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Ticket objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar(Ticket objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Ticket traer(int idTicket) {
		Ticket objeto = null;
		try {
			iniciaOperacion();
			objeto = (Ticket) session.get(Ticket.class, idTicket);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Ticket> traer() throws HibernateException {
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Ticket c order by c.idTicket asc",
					Ticket.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Ticket> filtrado(String filtro){
		List<Ticket> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Ticket t where t.estado =:filtro order by t.idTicket asc";
			lista = session.createQuery(hQL, Ticket.class).setParameter("filtro", filtro).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

}
