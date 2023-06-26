package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entité qui correspond à la table Marque
 * @author  kone mamoudou
 *
 */
@Entity
@Table(name = "marque")
public class Marque {
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


    /** constructeur */
    public Marque() {}

    public Marque(String nom) {
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
}
