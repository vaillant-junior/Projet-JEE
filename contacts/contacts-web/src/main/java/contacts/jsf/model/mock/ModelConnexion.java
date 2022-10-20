package contacts.jsf.model.mock;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import contacts.jsf.data.Compte;
import contacts.jsf.data.mapper.IMapper;
import contacts.jsf.util.CompteActif;
import contacts.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private Compte		courant;

	@Inject
	private CompteActif	compteActif;
	@Inject
	private ModelInfo	modelInfo;
	@Inject
	private Donnees		données;
	@Inject
	private IMapper		mapper;


	// Getters
	
	public Compte getCourant() {
		if ( courant == null ) {
			courant = new Compte();
		}
		return courant;
	}

	
	// Actons
	
	public String connect() {

		Compte compte = null;
		for ( Compte item : données.getComptes() ) {
			if ( item.getPseudo().equals( courant.getPseudo() )
					&& item.getMotDePasse().equals( courant.getMotDePasse()) ) {
				compte = item;
				break;
			}
		}
	    
	    if ( compte != null ){

	        mapper.update(compteActif, compte);
	        UtilJsf.messageInfo( "Connexion réussie" );
	        
	    	modelInfo.setTitre( "Bienvenue" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + compteActif.getPseudo() +"'.");

		    return "info";

	    } else {
	        UtilJsf.messageError( "Pseudo ou mot de passe invalide." );
	    	return null;
	    }
	}	
}
