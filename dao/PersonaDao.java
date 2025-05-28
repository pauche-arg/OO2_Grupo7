package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Persona;
import datos.Usuario;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos de ControlDao.", he);
	}
	
	protected PersonaDao() {
		
	}
	
	public static PersonaDao getInstance() {
		if(instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}
	
	public int agregar(Persona objeto) {
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
	
	public void actualizar(Persona objeto) {
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
	
	public void eliminar(Persona objeto) {
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
	
	public Persona traer(int idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traerId(int idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona p where p.idPersona=:idPersona")
			.setParameter("idPersona", idPersona).uniqueResult();
			} finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traer(String dni) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("FROM Persona WHERE dni = :dni").setParameter("dni", dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Persona> traer() throws HibernateException {
		List<Persona> lista =null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Persona",Persona.class).list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	public List<Usuario> traerUsuarios(){
		List<Usuario> lista =null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Usuario",Usuario.class).list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	public List<Empleado> traerEmpleados(){
		List<Empleado> lista =null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Empleado",Empleado.class).list();
		}finally {
			session.close();
		}
		return lista;
	}

}
