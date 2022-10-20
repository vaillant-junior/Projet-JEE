package contacts.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import contacts.commun.dto.DtoCompte;
import contacts.commun.service.IServiceConnexion;
import contacts.ejb.dao.IDaoCompte;
import contacts.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceConnexion implements IServiceConnexion {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoCompte daoCompte;

	// Actions

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoCompte sessionUtilisateurOuvrir(String pseudo, String motDePasse) {
		DtoCompte compte = mapper.map(daoCompte.validerAuthentification(pseudo, motDePasse));
		return compte;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public void sessionUtilisateurFermer() {
	}

}
