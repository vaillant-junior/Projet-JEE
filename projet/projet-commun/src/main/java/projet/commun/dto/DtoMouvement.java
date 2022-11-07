package projet.commun.dto;

import java.io.Serializable;
import java.security.Timestamp;


@SuppressWarnings("serial")
public class DtoMouvement implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private Timestamp		dateMouvement;
	
	private double		montant;
	
	private String		typeMouvement;
	
	private DtoCompte compte;
	
	// Constructeurs
	
	public DtoMouvement() {
	}

	public DtoMouvement(int id, Timestamp dateMouvement, double montant, String typeMouvement,DtoCompte compte ) {
		this.id = id;
		this.dateMouvement = dateMouvement;
		this.montant = montant;
		this.typeMouvement = typeMouvement;
		this.compte = compte;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateMouvement() {
		return dateMouvement;
	}

	public void setDateMouvement(Timestamp dateMouvement) {
		this.dateMouvement = dateMouvement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getTypeMouvement() {
		return typeMouvement;
	}

	public void setTypeMouvement(String typeMouvement) {
		this.typeMouvement = typeMouvement;
	}

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}

	
}
