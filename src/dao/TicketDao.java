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
			
			System.out.println(objeto.getUsuarioCreador());
			
			UsuarioDao usuarioDao = new UsuarioDao();
			EmpleadoDao empleadoDao = new EmpleadoDao();
			
			Usuario usuario = null;
			Empleado empleado = null;
	       
	        
	        try { 
	        if (objeto.getUsuarioCreador() != null) {
	            Integer idUsuario = objeto.getUsuarioCreador().getIdUsuario();
	            usuario = usuarioDao.traer(idUsuario);
	            objeto.setUsuarioCreador(usuario);
	        }
	        } catch (HibernateException he) {
	        	manejaExcepcion(he);
	        }
	        if (objeto.getEmpleadoAsignado() != null) {
	            Integer idEmpleado = objeto.getEmpleadoAsignado().getIdUsuario();
	            empleado = empleadoDao.traer(idEmpleado);
	            objeto.setEmpleadoAsignado(empleado); // puede seguir siendo null si no lo encuentra, dado que cuando los ticket son creados pueden no tener un empleado asignado ae el
	        } else {
	            objeto.setEmpleadoAsignado(null);
	        }
			
			objeto.setUsuarioCreador(usuario);
			
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
			
			UsuarioDao usuarioDao = new UsuarioDao();
			EmpleadoDao empleadoDao = new EmpleadoDao();
			
			Usuario usuario = usuarioDao.traer(objeto.getUsuarioCreador().getIdUsuario());
	        Empleado empleado = empleadoDao.traer(objeto.getEmpleadoAsignado().getIdUsuario());
	        
	        if (usuario == null) {
	            throw new IllegalArgumentException("TicketDao: Usuario creador no encontrado.");
	        }
	        if (empleado == null) {
	            throw new IllegalArgumentException("TicketDao: Empleado no encontrado");
	        }
			
			objeto.setUsuarioCreador(usuario);
			objeto.setEmpleadoAsignado(empleado);
			
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
}
