package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoProduit;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceProduit;
import projet.ejb.dao.IDaoProduit;
import projet.ejb.data.Produit;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceProduit implements IServiceProduit {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoProduit daoProduit;

	// Actions

	@Override
	public int inserer(DtoProduit dtoProduit) throws ExceptionValidation {
		verifierValiditeDonnees(dtoProduit);
		int id = daoProduit.inserer(mapper.map(dtoProduit));
		return id;
	}

	@Override
	public void modifier(DtoProduit dtoProduit) throws ExceptionValidation {
		verifierValiditeDonnees(dtoProduit);
		daoProduit.modifier(mapper.map(dtoProduit));
	}

	@Override
	public void supprimer(int idProduit) throws ExceptionValidation {
		daoProduit.supprimer(idProduit);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoProduit retrouver(int idProduit) {
		return mapper.map(daoProduit.retrouver(idProduit));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoProduit> listerTout() {
		List<DtoProduit> liste = new ArrayList<>();
		for (Produit produit : daoProduit.listerTout()) {
			liste.add(mapper.map(produit));
		}
		return liste;
	}

	// Méthodes auxiliaires

		private void verifierValiditeDonnees(DtoProduit dtoProduit) throws ExceptionValidation {

			
		}


}
