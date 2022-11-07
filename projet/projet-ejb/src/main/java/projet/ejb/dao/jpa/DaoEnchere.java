package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEnchere;
import projet.ejb.data.Enchere;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEnchere implements IDaoEnchere {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Enchere enchere) {
		em.persist(enchere);
		em.flush();
		return enchere.getIdenchere();
	}

	@Override
	public void modifier(Enchere enchere) {
		em.merge( enchere );
	}

	@Override
	public void supprimer(int idEnchere) {
		em.remove( retrouver(idEnchere) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Enchere retrouver(int idEnchere) {
		return em.find( Enchere.class, idEnchere );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enchere> listerTout() {
		em.clear();
		var jpql = "SELECT e FROM Enchere e ORDER BY e.montant";
		var query = em.createQuery( jpql, Enchere.class );
		return query.getResultList();
	}


	
}
