package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enchere database table.
 * 
 */
@Entity
@NamedQuery(name="Enchere.findAll", query="SELECT e FROM Enchere e")
public class Enchere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idenchere;

	private double montant;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit")
	private Produit produit;

	public Enchere() {
	}

	public Integer getIdenchere() {
		return this.idenchere;
	}

	public void setIdenchere(Integer idenchere) {
		this.idenchere = idenchere;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}