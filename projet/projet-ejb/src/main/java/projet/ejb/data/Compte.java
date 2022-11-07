package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcompte;

	private double credit;

	private String email;

	private String motDePasse;

	private String nom;

	private String prenom;

	private String pseudo;

	//bi-directional many-to-one association to Mouvement
	@OneToMany(mappedBy="compte")
	private List<Mouvement> mouvements;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="compte1")
	private List<Produit> produits1;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="compte2")
	private List<Produit> produits2;

	public Compte() {
	}

	public Integer getIdcompte() {
		return this.idcompte;
	}

	public void setIdcompte(Integer idcompte) {
		this.idcompte = idcompte;
	}

	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return this.motDePasse;
	}

	public void setMotdepasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Mouvement> getMouvements() {
		return this.mouvements;
	}

	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public Mouvement addMouvement(Mouvement mouvement) {
		getMouvements().add(mouvement);
		mouvement.setCompte(this);

		return mouvement;
	}

	public Mouvement removeMouvement(Mouvement mouvement) {
		getMouvements().remove(mouvement);
		mouvement.setCompte(null);

		return mouvement;
	}

	public List<Produit> getProduits1() {
		return this.produits1;
	}

	public void setProduits1(List<Produit> produits1) {
		this.produits1 = produits1;
	}

	public Produit addProduits1(Produit produits1) {
		getProduits1().add(produits1);
		produits1.setCompte1(this);

		return produits1;
	}

	public Produit removeProduits1(Produit produits1) {
		getProduits1().remove(produits1);
		produits1.setCompte1(null);

		return produits1;
	}

	public List<Produit> getProduits2() {
		return this.produits2;
	}

	public void setProduits2(List<Produit> produits2) {
		this.produits2 = produits2;
	}

	public Produit addProduits2(Produit produits2) {
		getProduits2().add(produits2);
		produits2.setCompte2(this);

		return produits2;
	}

	public Produit removeProduits2(Produit produits2) {
		getProduits2().remove(produits2);
		produits2.setCompte2(null);

		return produits2;
	}

}