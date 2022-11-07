package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mouvement database table.
 * 
 */
@Entity
@NamedQuery(name="Mouvement.findAll", query="SELECT m FROM Mouvement m")
public class Mouvement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmouvement;

	private Timestamp datemouvement;

	private double montant;

	private String typemouvement;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idcompte")
	private Compte compte;

	public Mouvement() {
	}

	public Integer getIdmouvement() {
		return this.idmouvement;
	}

	public void setIdmouvement(Integer idmouvement) {
		this.idmouvement = idmouvement;
	}

	public Timestamp getDatemouvement() {
		return this.datemouvement;
	}

	public void setDatemouvement(Timestamp datemouvement) {
		this.datemouvement = datemouvement;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getTypemouvement() {
		return this.typemouvement;
	}

	public void setTypemouvement(String typemouvement) {
		this.typemouvement = typemouvement;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}