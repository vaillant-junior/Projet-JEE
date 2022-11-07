package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;


@SuppressWarnings("serial")
public class Enchere implements Serializable  {

	
	// Champs
	
	private Integer			id;
	
	private double		montant;
	
	private Produit produit;
		
	// Constructeurs
	
	public Enchere() {
	}

	public Enchere(int id, double montant, Produit produit) {
		this.id = id;
		this.montant = montant;
		this.produit = produit;
	}
	
	
	// Getters & setters
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
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
		Enchere other = (Enchere) obj;
		return Objects.equals(id, other.id);
	}
}
