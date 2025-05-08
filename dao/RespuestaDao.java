package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Respuesta;

import dao.TicketDao;

public class RespuestaDao {
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
	
	public int agregar(Respuesta objeto) {
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
	
	public void actualizar(Respuesta objeto) {
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
	
	public void eliminar(Respuesta objeto) {
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
	
	public Respuesta traer(int idRespuesta) {
		Respuesta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Respuesta) session.get(Respuesta.class, idRespuesta);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Respuesta> traer() throws HibernateException {
		List<Respuesta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Respuesta c order by c.idRespuesta asc",
					Respuesta.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
