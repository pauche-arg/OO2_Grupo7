package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Usuario;

public class UsuarioDao {
	private static Session session;
	private Transaction tx;
	private static UsuarioDao instancia = null;

	protected UsuarioDao() {

	}

	public static UsuarioDao getInstance() {
		if (instancia == null)
			instancia = new UsuarioDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public Usuario traer(int idUsuario) {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.idUsuario=:idUsuario")
					.setParameter("idUsuario", idUsuario).uniqueResult();
		} finally {
			session.close();
		}
		System.out.println(objeto.getDni());
		return objeto;
	}

	public List<Usuario> traer() throws HibernateException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Usuario", Usuario.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public int agregar(Usuario objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
			System.out.printf("id %d",id);
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public int agregarEmpl(Usuario objeto) {
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

	public void actualizar(Usuario objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
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
		} finally {
			session.close();
		}
	}


	public Usuario traerDni(String dni) {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.dni=:dni").setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

}

