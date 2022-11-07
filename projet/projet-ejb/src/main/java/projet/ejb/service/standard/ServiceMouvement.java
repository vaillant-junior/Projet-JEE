package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoMouvement;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceMouvement;
import projet.ejb.dao.IDaoMouvement;
import projet.ejb.data.Mouvement;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceMouvement implements IServiceMouvement {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoMouvement daoMouvement;

	// Actions

	@Override
	public int inserer(DtoMouvement dtoMouvement) throws ExceptionValidation {
		verifierValiditeDonnees(dtoMouvement);
		int id = daoMouvement.inserer(mapper.map(dtoMouvement));
		return id;
	}

	@Override
	public void modifier(DtoMouvement dtoMouvement) throws ExceptionValidation {
		verifierValiditeDonnees(dtoMouvement);
		daoMouvement.modifier(mapper.map(dtoMouvement));
	}

	@Override
	public void supprimer(int idMouvement) throws ExceptionValidation {
		daoMouvement.supprimer(idMouvement);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoMouvement retrouver(int idMouvement) {
		return mapper.map(daoMouvement.retrouver(idMouvement));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoMouvement> listerTout() {
		List<DtoMouvement> liste = new ArrayList<>();
		for (Mouvement mouvement : daoMouvement.listerTout()) {
			liste.add(mapper.map(mouvement));
		}
		return liste;
	}

	// Méthodes auxiliaires

		private void verifierValiditeDonnees(DtoMouvement dtoMouvement) throws ExceptionValidation {

			
		}


}
