package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entity qui correspond à la table aditif
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "additif")
@Cacheable
public class Additif {
    //-------------{ ATTRIBUT }----------------//

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "produit_additif",
            joinColumns = @JoinColumn(name = "id_additif",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produit",referencedColumnName = "id"))
    private Set<Produit> produits = new HashSet<Produit>();

    //-------------{ CONSTRUCTOR }----------------//

    public Additif() {}

    public Additif(String nom) {
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
        Additif additif = (Additif) o;
        return id == additif.id && Objects.equals(nom, additif.nom) && Objects.equals(produits, additif.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, produits);
    }
}
