package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Control;
import datos.Empleado;
import datos.Ticket;
import datos.Usuario;
import dao.UsuarioDao;
import dao.EmpleadoDao;

public class ControlDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos de ControlDao.", he);
	}
	
	public int agregar(Control objeto) {
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
	
	public void actualizar(Control objeto) {
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
	
	public void eliminar(Control objeto) {
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
	
	public Control traer(int idControl) {
		Control objeto = null;
		try {
			iniciaOperacion();
			objeto = (Control) session.get(Control.class, idControl);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Control> traer() throws HibernateException {
		List<Control> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Control c order by c.idControl asc",
					Control.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	//Mejorar nombre de metodo, filtra de que manera y para que proposito?
	public List<Control> filtrado(String filtro){
		List<Control> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Control t where t.estado =:filtro order by t.idControl asc";
			lista = session.createQuery(hQL, Control.class).setParameter("filtro", filtro).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

}
