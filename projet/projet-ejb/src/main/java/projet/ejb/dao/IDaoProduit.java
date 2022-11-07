package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Produit;


public interface IDaoProduit {

	int			inserer( Produit produit);

	void 		modifier( Produit produit );

	void 		supprimer( int idProduit );

	Produit 		retrouver( int idProduit );

	List<Produit> listerTout();


}
