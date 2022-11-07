package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoEnchere;
import projet.commun.exception.ExceptionValidation;


public interface IServiceEnchere {
	
	int				inserer( DtoEnchere dtoEnchere ) throws ExceptionValidation;

	void			modifier( DtoEnchere dtoEnchere ) throws ExceptionValidation; 

	void			supprimer( int idEnchere ) throws ExceptionValidation;

	DtoEnchere 		retrouver( int idEnchere ) ;

	List<DtoEnchere>	listerTout() ;

}
