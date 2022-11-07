package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoProduit;
import projet.ejb.data.Produit;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoProduit implements IDaoProduit {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Produit produit) {
		em.persist(produit);
		em.flush();
		return produit.getIdproduit();
	}

	@Override
	public void modifier(Produit produit) {
		em.merge( produit );
	}

	@Override
	public void supprimer(int idProduit) {
		em.remove( retrouver(idProduit) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Produit retrouver(int idProduit) {
		return em.find( Produit.class, idProduit );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Produit> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Produit p ORDER BY p.nom";
		var query = em.createQuery( jpql, Produit.class );
		return query.getResultList();
	}

}
