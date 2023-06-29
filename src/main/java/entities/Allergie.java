package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité qui correspond à la table Allergie
 * @author  kone mamoudou et khalid
 *
 */

@Entity
@Table(name = "allergie")
@Cacheable
public class Allergie {

    //-------------{ ATTRIBUT }----------------//
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")
    private String nom;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "produit_allergie",
                joinColumns = @JoinColumn(name = "id_allergie",referencedColumnName = "id"),
                 inverseJoinColumns = @JoinColumn(name = "id_produit",referencedColumnName = "id"))
    private Set<Produit> produits = new HashSet<Produit>();

    //-------------{ CONSTRUCTOR }----------------//
    public Allergie() {}


    public Allergie(String nom) {
        this.nom = nom;
    }

    //-------------{ METHODS }----------------//


    //-------------{ GETTERS ET SETTERS }----------------//
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

    //-------------{ OVERRIDE}----------------//

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergie allergie = (Allergie) o;
        return Objects.equals(nom, allergie.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
