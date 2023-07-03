package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité qui correspond à la table Ingredient
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "ingrdient")
@Cacheable
public class Ingredient {
    //-------------{ ATTRIBUT }----------------//

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private  String nom ;

    /**
     * Plusieurs ingredients peuvent etre dans plusieurs produits
     */
    @ManyToMany(mappedBy = "ingredients",cascade = { CascadeType.MERGE})
    private Set<Produit> produits = new HashSet<Produit>();

    //-------------{ CONSTRUCTOR }----------------//
    public Ingredient() {}

    public Ingredient(String nom) {
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
        Ingredient that = (Ingredient) o;
        return id == that.id && Objects.equals(nom, that.nom) && Objects.equals(produits, that.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, produits);
    }
}
