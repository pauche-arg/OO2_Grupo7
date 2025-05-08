package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Usuario;
import datos.Ticket;
import datos.Usuario;
import negocio.TicketABM;


public class EmpleadoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos de EmpleadoDao.", he);
	}
	
	public int agregar(Empleado objeto) {
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
	
	public void actualizar(Empleado objeto) {
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
	
	public void eliminar(Empleado objeto) {
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
	
	public Empleado traer(int idUsuario) {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.get(Empleado.class, idUsuario);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Empleado traer(String dni) {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.createQuery("FROM Empleado WHERE dni = :dni")
									  .setParameter("dni", dni)
									  .uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Empleado> traer() throws HibernateException {
		List<Empleado> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Empleado c order by c.idUsuario asc",
					Empleado.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public void cambiarEstado(int ticket, Empleado emp) throws Exception{
		TicketABM abm = new TicketABM();
		Ticket t = abm.traerTicket(ticket);
		if(t.getEmpleadoAsignado().getIdUsuario()!=emp.getIdUsuario())throw new Exception("Este empleado no esta acargo del ticket");	
		t.setEstado("resuelto");
		abm.modificar(t);
		System.out.println("Se cambio con exito");
	}
}
