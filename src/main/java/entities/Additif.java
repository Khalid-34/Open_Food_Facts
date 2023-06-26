package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity qui correspond à la table aditif
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "additif")
public class Additif {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany
    @JoinTable(name = "produit_additif",
            joinColumns = @JoinColumn(name = "id_additif",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produit",referencedColumnName = "id"))
    private Set<Produit> produits = new HashSet<Produit>();

    /** Constructeur */
    public Additif() {}

    public Additif(String nom) {
        this.nom = nom;
    }

    /** Getters et Setters */
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
