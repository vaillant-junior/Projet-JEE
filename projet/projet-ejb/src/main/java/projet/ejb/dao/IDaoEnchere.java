package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Enchere;


public interface IDaoEnchere {

	int			inserer( Enchere enchere );

	void 		modifier( Enchere enchere );

	void 		supprimer( int idEnchere );

	Enchere 		retrouver( int idEnchere );

	List<Enchere> listerTout();

}
