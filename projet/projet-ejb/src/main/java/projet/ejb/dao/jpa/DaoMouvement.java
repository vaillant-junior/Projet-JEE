package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoMouvement;
import projet.ejb.data.Mouvement;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoMouvement implements IDaoMouvement {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Mouvement mouvement) {
		em.persist(mouvement);
		em.flush();
		return mouvement.getIdmouvement();
	}

	@Override
	public void modifier(Mouvement mouvement) {
		em.merge( mouvement );
	}

	@Override
	public void supprimer(int idMouvement) {
		em.remove( retrouver(idMouvement) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Mouvement retrouver(int idMouvement) {
		return em.find( Mouvement.class, idMouvement );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Mouvement> listerTout() {
		em.clear();
		var jpql = "SELECT m FROM Mouvement m ORDER BY m.typemouvement";
		var query = em.createQuery( jpql, Mouvement.class );
		return query.getResultList();
	}


	
	
}
