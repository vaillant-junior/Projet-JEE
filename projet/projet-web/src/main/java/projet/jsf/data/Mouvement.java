package projet.jsf.data;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@SuppressWarnings("serial")
public class Mouvement implements Serializable  {

	
	// Champs
	
	private Integer			id;
	
	private Timestamp		dateMouvement;
	
	private double		montant;
	@NotBlank( message = "Le type de mouvement  doit être renseigné")
	@Pattern(regexp = "[VR]", message = "Uniquement les lettres V pour versement ou R pour retrait")
	private String		typeMouvement;
	
	private Compte compte;
	
	// Constructeurs
	
	public Mouvement() {
	}

	public Mouvement(int id, Timestamp dateMouvement, double montant, String typeMouvement,Compte compte ) {
		this.id = id;
		this.dateMouvement = dateMouvement;
		this.montant = montant;
		this.typeMouvement = typeMouvement;
		this.compte = compte;
	}
	
	
	// Getters & setters

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mouvement other = (Mouvement) obj;
		return id == other.id;
	}

	
}
