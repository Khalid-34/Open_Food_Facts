package entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Entité qui correspond à la table categorie
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "category")
@Cacheable
public class Category {
    //-------------{ ATTRIBUT }----------------//

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

    //-------------{ CONSTRUCTOR }----------------//
    public Category() {}

    public Category(String nom) {
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
        Category category = (Category) o;
        return id == category.id && Objects.equals(nom, category.nom) && Objects.equals(produits, category.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, produits);
    }
}
