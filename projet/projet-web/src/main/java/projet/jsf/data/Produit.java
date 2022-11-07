package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Produit implements Serializable  {

	
	// Champs
	
	private Integer			id;
	
	private boolean		cloturee;
	
	private LocalDateTime		debutenchere;
	
	@NotBlank( message = "La description doit être renseignée")
	@Size(max=100, message = "Valeur trop longue pour la description : 100 car. maxi" )
	private String		description;
	
	private LocalDateTime		finenchere;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String nom;
	
	@NotBlank( message = "La photo doit être renseignée")
	@Size(max=25, message = "Valeur trop longue pour la photo : 25 car. maxi" )
	private String photo;

	private double prixminimal;
	
	private List<Enchere> encheres;
	
	// Constructeurs
	
	public Produit() {
	}

	public Produit(int id, boolean cloturee, LocalDateTime debutenchere, String description, LocalDateTime finenchere,String nom,String photo,double prixminimal ) {
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

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}
	
}
