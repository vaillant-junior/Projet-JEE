package projet.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoEnchere implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private double		montant;
	
	private DtoProduit produit;
		
	// Constructeurs
	
	public DtoEnchere() {
	}

	public DtoEnchere(int id, double montant, DtoProduit produit) {
		this.id = id;
		this.montant = montant;
		this.produit = produit;
	}
	
	
	// Getters & setters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public DtoProduit getProduit() {
		return produit;
	}

	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}
}
