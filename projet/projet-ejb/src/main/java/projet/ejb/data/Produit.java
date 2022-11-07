package projet.ejb.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idproduit;

	private Boolean cloturee;

	private LocalDateTime debutenchere;

	private String description;

	private LocalDateTime finenchere;

	private String nom;

	private String photo;

	private double prixminimal;

	//bi-directional many-to-one association to Enchere
	@OneToMany(mappedBy="produit")
	private List<Enchere> encheres;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idacheteur")
	private Compte compte1;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="idvendeur")
	private Compte compte2;

	public Produit() {
	}

	public Integer getIdproduit() {
		return this.idproduit;
	}

	public void setIdproduit(Integer idproduit) {
		this.idproduit = idproduit;
	}

	public Boolean getCloturee() {
		return this.cloturee;
	}

	public void setCloturee(Boolean cloturee) {
		this.cloturee = cloturee;
	}

	public LocalDateTime getDebutenchere() {
		return this.debutenchere;
	}

	public void setDebutenchere(LocalDateTime debutenchere) {
		this.debutenchere = debutenchere;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getFinenchere() {
		return this.finenchere;
	}

	public void setFinenchere(LocalDateTime finenchere) {
		this.finenchere = finenchere;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrixminimal() {
		return this.prixminimal;
	}

	public void setPrixminimal(double prixminimal) {
		this.prixminimal = prixminimal;
	}

	public List<Enchere> getEncheres() {
		return this.encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Enchere addEnchere(Enchere enchere) {
		getEncheres().add(enchere);
		enchere.setProduit(this);

		return enchere;
	}

	public Enchere removeEnchere(Enchere enchere) {
		getEncheres().remove(enchere);
		enchere.setProduit(null);

		return enchere;
	}

	public Compte getCompte1() {
		return this.compte1;
	}

	public void setCompte1(Compte compte1) {
		this.compte1 = compte1;
	}

	public Compte getCompte2() {
		return this.compte2;
	}

	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}

}