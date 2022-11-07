package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoProduit;
import projet.commun.exception.ExceptionValidation;


public interface IServiceProduit {
	
	int				inserer( DtoProduit dtoProduit ) throws ExceptionValidation;

	void			modifier( DtoProduit dtoProduit ) throws ExceptionValidation; 

	void			supprimer( int idProduit ) throws ExceptionValidation;

	DtoProduit 		retrouver( int idProduit ) ;

	List<DtoProduit>	listerTout() ;

}
