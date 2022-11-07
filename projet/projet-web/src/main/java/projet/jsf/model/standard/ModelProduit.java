package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoProduit;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceProduit;
import projet.jsf.data.Produit;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelProduit implements Serializable {

	
	// Champs
	
	private List<Produit>	liste;
	
	private Produit			courant;
	
	@EJB
	private IServiceProduit	serviceProduit;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Produit> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoProduit dto : serviceProduit.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Produit getCourant() {
			if ( courant == null ) {
				courant = new Produit();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoProduit dto = serviceProduit.retrouver( courant.getId() ); 
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
				serviceProduit.inserer( mapper.map(courant) );
			} else {
				serviceProduit.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Produit item ) {
		try {
			serviceProduit.supprimer( item.getId() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
