package projet.commun.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("serial")
public class DtoProduit implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private boolean		cloturee;
	
	private LocalDateTime		debutenchere;
	
	private String		description;
	
	private LocalDateTime		finenchere;
	
	private String nom;
	
	private String photo;

	private double prixminimal;
	
	private List<DtoEnchere> encheres;
	
	// Constructeurs
	
	public DtoProduit() {
	}

	public DtoProduit(int id, boolean cloturee, LocalDateTime debutenchere, String description, LocalDateTime finenchere,String nom,String photo,double prixminimal ) {
		this.id = id;
		this.cloturee = cloturee;
		this.debutenchere = debutenchere;
		this.description = description;
		this.finenchere = finenchere;
		this.nom = nom;
		this.photo = photo;
		this.prixminimal = prixminimal;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public boolean isCloturee() {
		return cloturee;
	}

	public void setCloturee(boolean cloturee) {
		this.cloturee = cloturee;
	}

	public LocalDateTime getDebutenchere() {
		return debutenchere;
	}

	public void setDebutenchere(LocalDateTime debutenchere) {
		this.debutenchere = debutenchere;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getFinenchere() {
		return finenchere;
	}

	public void setFinenchere(LocalDateTime finenchere) {
		this.finenchere = finenchere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrixminimal() {
		return prixminimal;
	}

	public void setPrixminimal(double prixminimal) {
		this.prixminimal = prixminimal;
	}

	public List<DtoEnchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<DtoEnchere> encheres) {
		this.encheres = encheres;
	}

	
}
