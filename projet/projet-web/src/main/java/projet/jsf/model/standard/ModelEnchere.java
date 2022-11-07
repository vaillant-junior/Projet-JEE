package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoEnchere;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEnchere;
import projet.jsf.data.Enchere;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelEnchere implements Serializable {

	
	// Champs
	
	private List<Enchere>	liste;
	
	private Enchere			courant;
	
	@EJB
	private IServiceEnchere	serviceEnchere;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Enchere> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoEnchere dto : serviceEnchere.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Enchere getCourant() {
			if ( courant == null ) {
				courant = new Enchere();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoEnchere dto = serviceEnchere.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le compte demandé n'existe pas" );
				return "test/liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getId() == null) {
				serviceEnchere.inserer( mapper.map(courant) );
			} else {
				serviceEnchere.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Enchere item ) {
		try {
			serviceEnchere.supprimer( item.getId() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
