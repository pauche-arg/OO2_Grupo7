package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Usuario;

public class UsuarioDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos de UsuarioDao.", he);
	}
	
	public int agregar(Usuario objeto) {
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
	
	public void actualizar(Usuario objeto) {
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
	
	public void eliminar(Usuario objeto) {
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
	
	public Usuario traer(int idUsuario) {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.get(Usuario.class, idUsuario);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Usuario traer(String dni) {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("FROM Usuario WHERE dni = :dni")
									  .setParameter("dni", dni)
									  .uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Usuario> traer() throws HibernateException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Usuario c order by c.idUsuario asc",
					Usuario.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
