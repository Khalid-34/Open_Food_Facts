package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité qui correspond à la table Marque
 * @author  kone mamoudou
 *
 */
@Entity
@Table(name = "marque")
@Cacheable
public class Marque {
    //-------------{ ATTRIBUT }----------------//
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")
    private String nom;

    /**
     * Une marque peut avoir plusieurs produits
     */
    @OneToMany(mappedBy = "marque")
    private Set<Produit> produits = new HashSet<Produit>();


    //-------------{ CONSTRUCTOR }----------------//
    public Marque() {}

    public Marque(String nom) {
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
    //-------------{ OVERRIDE}----------------//


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque = (Marque) o;
        return id == marque.id && Objects.equals(nom, marque.nom) && Objects.equals(produits, marque.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, produits);
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", produits=" + produits +
                '}';
    }
}
