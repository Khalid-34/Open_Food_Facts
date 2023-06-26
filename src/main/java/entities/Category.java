package entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Entité qui correspond à la table categorie
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom")
    private String nom;

    /**
     * Une categorie peut avoir plusieurs produits
     */
    @OneToMany(mappedBy = "category")
    private Set<Produit> produits;

    /** Contructeur */
    public Category() {}

    public Category(String nom) {
        this.nom = nom;
    }

    /** Setters et Getters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
}
