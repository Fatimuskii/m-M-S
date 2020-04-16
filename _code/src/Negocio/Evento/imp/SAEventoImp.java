/**
 * 
 */
package Negocio.Evento.imp;

import Negocio.Empleado.imp.Empleado;
import Negocio.Evento.SAEvento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Ana �lava Pap�
 * @author �scar Canive Huguet
 * @author David Dom�nguez Guti�rrez
 * @author F�tima Garc�a Delgado
 * @author Marina Lozano Lahuerta
 * @author Paula S�nchez de la Nieta G�mez
 * @generated "UML a JPA
 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAEventoImp implements SAEvento {
	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#altaEvento(Evento evento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int altaEvento(TEvento tEvento) {
		int id = -1;
		
		if (tEvento != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				TypedQuery<Evento> query = entitymanager
						.createNamedQuery("Negocio.Evento.imp.Evento.findBynombre", Evento.class)
						.setParameter("nombre", tEvento.getNombre());
				List<Evento> res = query.getResultList();
				if (res.isEmpty()) { // El evento no existe
					Evento evento = new Evento(tEvento);
					tEvento.setActivo(true);
					entitymanager.persist(evento);
					entitytransaction.commit();
					id = evento.getId(); // resultado del alta evento
				} else { // El evento ya exist�a
					Evento eventoRes = res.get(0);
					if (eventoRes.getActivo()) { // Si el evento est� activo
						id = -2; // Evento ya activo en la base de datos
						entitytransaction.rollback();
					} else { // Reactivaci�n del evento (activo estaba a false)
						// Actualizar datos
						eventoRes.setActivo(true);
						eventoRes.setDireccion(tEvento.getDireccion());
						eventoRes.setNombre(tEvento.getNombre());
						eventoRes.setAforo(tEvento.getAforo());
						// commit
						entitytransaction.commit();
						// resultado del alta
						id = eventoRes.getId();
					}
				}
				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -1;
			}
		}

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#bajaEvento(int idEvento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int bajaEvento(int idEvento) {
		int id = -100;
		
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			Evento evento = entitymanager.find(Evento.class, idEvento);
			if (evento != null) { // evento existe
				if (evento.getActivo()) { // el evento est� activo
					TypedQuery<Participa> query = entitymanager
							.createNamedQuery("Negocio.Evento.imp.Participa.findByevento", Participa.class);
					query.setParameter("evento", evento);
					List<Participa> participa = query.getResultList();
					if (participa.isEmpty()) { // No hay empleados asignados al evento
						evento.setActivo(false);
						entitytransaction.commit();
						id = idEvento;
					} else {//Hay alg�n empleado asignado al evento
						id = -3;
						entitytransaction.rollback();
					}

				} else { // evento ya est� desactivado
					id = -2;
					entitytransaction.rollback();
				}
			}
			else{//evento no existe
				id = -1;
				entitytransaction.rollback();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
			id = -100;
		}

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#modificarEvento(Evento evento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int modificarEvento(TEvento tEvento) {
		int id = -100;
		if (tEvento != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				Evento evento = entitymanager.find(Evento.class, tEvento.getId());
				if (evento != null) { // Existe evento
					if (evento.getActivo()) { // Evento activo
						TypedQuery<Evento> query = entitymanager
								.createNamedQuery("Negocio.Evento.imp.Evento.findBynombre", Evento.class)
								.setParameter("nombre", tEvento.getNombre());
						List<Evento> lista = query.getResultList();
						//No existe un evento con ese nombre o si existe es �l mismo
						if (lista.isEmpty() || lista.get(0).getId() == tEvento.getId()) {
							evento.setNombre(tEvento.getNombre());
							evento.setDireccion(tEvento.getDireccion());
							evento.setAforo(tEvento.getAforo());
							entitytransaction.commit();
							id = tEvento.getId();
						} else { //Ya existe un evento con ese nombre
							id = -3;
							entitytransaction.rollback();
						}
					} else { //El evento no est� activo
						id = -2;
						entitytransaction.rollback();
					}
				} else {//El evento no existe
					id = -1;
					entitytransaction.rollback();
				}
				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -100;
			}
		}
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#buscarEvento(int idEvento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TEvento buscarEvento(int idEvento) {
		TEvento tEvento = null;

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			Evento evento = entitymanager.find(Evento.class, idEvento);

			if (evento == null) // no existe
				entitytransaction.rollback();
			else{
				tEvento = evento.toTransfer();
				entitytransaction.commit();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
		}

		return tEvento;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#listarEventos()
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<TEvento> listarEventos() {
		List<Evento> lista = null;
		List<TEvento> listaEventos=new ArrayList<TEvento>();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			TypedQuery<Evento> query = entitymanager.createNamedQuery("Negocio.Evento.imp.Evento.readAll", Evento.class);
			lista = query.getResultList();
			for(int i = 0; i < lista.size(); ++i) {
				listaEventos.add(lista.get(i).toTransfer());
			}
			entitytransaction.commit();

			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {}

		return listaEventos;
	}

	public List<TParticipa> mostrarEmpleadosdeEvento(int idEvento){
		List<TParticipa> res = new ArrayList<>();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Evento evento = entityManager.find(Evento.class, idEvento);
			if (evento != null && evento.getActivo()) {
				TypedQuery<Participa> consulta = entityManager
						.createNamedQuery("Negocio.Evento.imp.Participa.findByevento", Participa.class);
				consulta.setParameter("evento", evento);
				if (!consulta.getResultList().isEmpty()) {
					for (Participa p : consulta.getResultList()) {
						res.add(p.toTransfer());
					}
					entityTransaction.commit();
				} else
					entityTransaction.rollback();
			} else {
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		
		return res;
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#a�adirEmpleadoAEvento(TParticipa tParticipa)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int a�adirEmpleadoAEvento(TParticipa tParticipa) {
		int id = -100;
		if (tParticipa != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();

				Evento evento = entitymanager.find(Evento.class, tParticipa.getEvento(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				Empleado empleado = entitymanager.find(Empleado.class, tParticipa.getEmpleado(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);

				if (evento != null) {
					if (empleado != null) {
						if (evento.getActivo()) {
							if (empleado.getActivo()) {
								ParticipaId participaId = new ParticipaId(tParticipa.getEvento(),
										tParticipa.getEmpleado());
								Participa participaResult = entitymanager.find(Participa.class, participaId);

								if (participaResult == null) {
									Participa participa = new Participa(evento, empleado);
									participa.setActivo(true);
									participa.setFecha(new Date());
									entitymanager.persist(participa);
									entitytransaction.commit();
									id = participaId.hashCode();
								} else {
									if (participaResult.getActivo()) {// El empleado ya est� asignado al evento
										entitytransaction.rollback();
										id = -5;
									} else {// Se reactiva la asignaci�n del
											// empleado al evento
										participaResult.setActivo(true);
										participaResult.setFecha(new Date());
										entitytransaction.commit();
										id = participaId.hashCode();
									}
								}
							} else {// Empleado no activo
								id = -4;
								entitytransaction.rollback();
							}
						} else {// Evento no activo
							id = -3;
							entitytransaction.rollback();
						}

					} else {// Empleado no existe
						entitytransaction.rollback();
						id = -2;
					}
				} else {// Evento no existe
					entitytransaction.rollback();
					id = -1;
				}

				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -100;
			}
		}
	
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAEvento#eliminarEmpleadoDeEvento(TParticipa tParticipa)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int eliminarEmpleadoDeEvento(TParticipa tParticipa) {
		int id = -1;
		if(tParticipa != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				
				entitytransaction.begin();
				Evento evento = entitymanager.find(Evento.class, tParticipa.getEvento(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				Empleado empleado = entitymanager.find(Empleado.class, tParticipa.getEmpleado(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);

				if (evento != null) {
					if (empleado != null) {
						if (evento.getActivo()) {
							if (empleado.getActivo()) {
								ParticipaId participaId = new ParticipaId(tParticipa.getEvento(),
										tParticipa.getEmpleado());
								Participa participaResult = entitymanager.find(Participa.class, participaId);
									if(participaResult == null) {//El empleado no est� asignado a ese evento
										entitytransaction.rollback();
										id = -6;
									} else {
										if(participaResult.getActivo()) {
											participaResult.setActivo(false);
											entitytransaction.commit();
											id = participaId.hashCode();
											
										} else {//El empleado ya est� desasignado del evento
											entitytransaction.rollback();
											id = -5;
										}
									}
								} else {//El empleado no est� activo
									entitytransaction.rollback();
									id = -4;
								}
	
							} else {//El evento no est� activo
								entitytransaction.rollback();
								id = -3;
							}
						} else {//No existe el empleado
							entitytransaction.rollback();
							id = -2;
						}
					} else {//No existe el evento
						entitytransaction.rollback();
						id = -1;
					}
				
			
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {
				id = -100;
			}
		}
		return id;
	}
}