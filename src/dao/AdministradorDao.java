package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Administrador;
import datos.Empleado;
import datos.Ticket;
import datos.Usuario;
import negocio.TicketABM;

public class AdministradorDao {
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
	
	public int agregar(Administrador objeto) {
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
	
	public void actualizar(Administrador objeto) {
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
	
	public void eliminar(Administrador objeto) {
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
	
	public Administrador traer(int idUsuario) {
		Administrador objeto = null;
		try {
			iniciaOperacion();
			objeto = (Administrador) session.get(Administrador.class, idUsuario);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Administrador traer(String dni) {
		Administrador objeto = null;
		try {
			iniciaOperacion();
			objeto = (Administrador) session.createQuery("FROM Administrador WHERE dni = :dni")
									  .setParameter("dni", dni)
									  .uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Administrador> traer() throws HibernateException {
		List<Administrador> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Administrador c order by c.idUsuario asc",
					Administrador.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public void asignarTicket(int idticket, Empleado emp) throws Exception {
		TicketABM abmti = new TicketABM();
		Ticket t = abmti.traerTicket(idticket);
		if(t.getEstado().equalsIgnoreCase("resuelto"))throw new Exception("El ticket ya esta resuelto");
		t.setEmpleadoAsignado(emp);
		abmti.modificar(t);
		System.out.println(t);
	}
}
